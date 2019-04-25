package com.comb.TeamRankService.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.comb.mapper.TbTeamCheckMapper;
import com.comb.mapper.TbTeamUserMapper;
import com.comb.pojo.TbTeamCheck;
import com.comb.pojo.TbTeamCheckExample;
import com.comb.pojo.TbTeamCheckExample.Criteria;
import com.comb.pojo.TbTeamUser;
import com.comb.rank.service.TeamRankService;

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
	public List<TbTeamUser> rankByMonthOrder(){
		TbTeamCheckExample example = new TbTeamCheckExample();
		example.setOrderByClause("month_order");
		Criteria criteria = example.createCriteria();
		List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
		List<TbTeamUser> list2 = new ArrayList<>();
		for(TbTeamCheck it : list) {
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
			list2.add(teamUser);
		}
		return list2;
	}
	
	public List<TbTeamUser> rankByPv(){
		TbTeamCheckExample example = new TbTeamCheckExample();
		example.setOrderByClause("pv");
		Criteria criteria = example.createCriteria();
		List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
		List<TbTeamUser> list2 = new ArrayList<>();
		for(TbTeamCheck it : list) {
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
			list2.add(teamUser);
		}
		return list2;
	}
	
	public List<TbTeamUser> rankByYearOrder(){
		TbTeamCheckExample example = new TbTeamCheckExample();
		example.setOrderByClause("year_order");
		Criteria criteria = example.createCriteria();
		List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
		List<TbTeamUser> list2 = new ArrayList<>();
		for(TbTeamCheck it : list) {
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
			list2.add(teamUser);
		}
		return list2;
	}
	
	public List<TbTeamUser> rankByStar(){
		TbTeamCheckExample example = new TbTeamCheckExample();
		example.setOrderByClause("star");
		Criteria criteria = example.createCriteria();
		List<TbTeamCheck> list = teamCheckMapper.selectByExample(example);
		List<TbTeamUser> list2 = new ArrayList<>();
		for(TbTeamCheck it : list) {
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(it.getTeamId());
			list2.add(teamUser);
		}
		return list2;
	}
	
}
