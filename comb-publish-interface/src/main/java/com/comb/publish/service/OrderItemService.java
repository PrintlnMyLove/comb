package com.comb.publish.service;


import java.util.List;
import com.comb.pojo.TbOrderItem;

import entity.PageResult;
/**
 * 
 * @author WangQingBang
 *
 */
public interface OrderItemService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbOrderItem> findAll();
	
	/**
	 * 查询商品
	 * @param id
	 * @return
	 */
	public List<TbOrderItem> findGood(String id);
	
	/**
	 * 返回分页列表
	 * @return
	 */
//	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbOrderItem orderItem);
	
	
	/**
	 * 修改
	 */
	public void update(TbOrderItem orderItem);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbOrderItem findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbOrderItem orderItem, int pageNum,int pageSize);
	
}
