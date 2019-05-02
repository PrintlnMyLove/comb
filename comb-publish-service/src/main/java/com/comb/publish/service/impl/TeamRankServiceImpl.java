package com.comb.publish.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.comb.mapper.TbTeamCheckMapper;
import com.comb.mapper.TbTeamUserMapper;
import com.comb.pojo.TbTeamCheck;
import com.comb.pojo.TbTeamCheckExample;
import com.comb.pojo.TbTeamUser;
import com.comb.pojogroup.TeamUserCheck;
import com.comb.publish.service.TeamRankService;

@Service(timeout=60000)
public class TeamRankServiceImpl implements TeamRankService{
	
	@Autowired
	private TbTeamCheckMapper teamCheckMapper;
	
	@Autowired 
	private TbTeamUserMapper teamUserMapper;
	
	/**
	 * 按月订单数进行排序
	 * @return
	 */
	public List<TeamUserCheck> rankBygroup(){
		List<TeamUserCheck> teamUserChecks = new ArrayList<>(); 
		TbTeamCheckExample example = new TbTeamCheckExample();
		example.setOrderByClause("((month_order/pv)*0.4+(star/year_order)*0.6) desc");
		List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
		for(TbTeamCheck it : list) {
			TeamUserCheck teamUserCheck = new TeamUserCheck();
			teamUserCheck.setTeamCheck(it);
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
			teamUserCheck.setTeamUser(teamUser);
			teamUserChecks.add(teamUserCheck);
		}
		return teamUserChecks;
	}
	
	/**
	 * 按pv转化率来排序
	 */
	public List<TeamUserCheck> rankByPv(){
		List<TeamUserCheck> teamUserChecks = new ArrayList<>(); 
		TbTeamCheckExample example = new TbTeamCheckExample();
		example.setOrderByClause("(year_order/pv) desc");
		List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
		for(TbTeamCheck it : list) {
			TeamUserCheck teamUserCheck = new TeamUserCheck();
			teamUserCheck.setTeamCheck(it);
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
			teamUserCheck.setTeamUser(teamUser);
			teamUserChecks.add(teamUserCheck);
		}
		return teamUserChecks;
	}
	

	
	/**
	 * 按好评率来排序
	 */
	public List<TeamUserCheck> rankByStarRate(){
		 List<TeamUserCheck> teamUserChecks = new ArrayList<>(); 
			TbTeamCheckExample example = new TbTeamCheckExample();
			example.setOrderByClause("(star/year_order) desc");
			List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
			for(TbTeamCheck it : list) {
				TeamUserCheck teamUserCheck = new TeamUserCheck();
				teamUserCheck.setTeamCheck(it);
				TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
				teamUserCheck.setTeamUser(teamUser);
				teamUserChecks.add(teamUserCheck);
			}
			return teamUserChecks;
	}
	
}
