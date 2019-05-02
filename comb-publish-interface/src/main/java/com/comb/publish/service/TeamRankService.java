package com.comb.publish.service;

import java.util.List;

import com.comb.pojogroup.TeamUserCheck;


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
	public List<TeamUserCheck> rankBygroup();
	/**
	 * 按pv排序
	 * @return
	 */
	public List<TeamUserCheck> rankByPv();
	/**
	 * 按好评数得分
	 * @return
	 */
	public List<TeamUserCheck> rankByStarRate();
	
	
}
