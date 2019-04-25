package com.comb.user.service;

import java.util.List;

import com.comb.pojo.TbOrder;
import com.comb.pojogroup.Order;

import entity.PageResult;
import entity.Result;

/**
 * 
 * @author WangQingBang
 *
 */
public interface OrderService {

	public List<Order> findOrderList(String username);
	
	public void ensureOrder(String id);
	
	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbOrder order, int pageNum,int pageSize);
	
	public Order findOrder(String id);

	/**
	 * 评价数
	 * @param star
	 */
	public void evaluation(int star, String sellerId,String id);
}
