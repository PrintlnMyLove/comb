package com.comb.rank.service;

import java.util.List;

import com.comb.pojo.TbTeamUser;

/**
 * 
 * @author WangQingBang
 *
 */
public interface TeamRankService {
	
	/**
	 * 按月订单排序
	 * @return
	 */
	public List<TbTeamUser> rankByMonthOrder();
	/**
	 * 按pv排序
	 * @return
	 */
	public List<TbTeamUser> rankByPv();
	/**
	 * 按年订单排序
	 * @return
	 */
	public List<TbTeamUser> rankByYearOrder();
	/**
	 * 按好评数得分
	 * @return
	 */
	public List<TbTeamUser> rankByStar();
	
	
}
