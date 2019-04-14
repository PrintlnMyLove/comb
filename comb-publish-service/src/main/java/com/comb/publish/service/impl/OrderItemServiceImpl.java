package com.comb.publish.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.comb.mapper.TbOrderItemMapper;
import com.comb.pojo.TbOrderItem;
import com.comb.pojo.TbOrderItemExample;
import com.comb.pojo.TbOrderItemExample.Criteria;
import com.comb.publish.service.OrderItemService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service(timeout=60000)
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private TbOrderItemMapper orderItemMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbOrderItem> findAll() {
		return orderItemMapper.selectByExample(null);
	}
	
	
	@Override
	public List<TbOrderItem> findGood(String id) {
		
		TbOrderItemExample example=new TbOrderItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(id);
		List<TbOrderItem> list = orderItemMapper.selectByExample(example);
		return list;
	}

	/**
	 * 按分页查询
	 */
//	@Override
//	public PageResult findPage(int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);		
//		Page<TbOrderItem> page=   (Page<TbOrderItem>) orderItemMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
//	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbOrderItem orderItem) {
		orderItemMapper.insert(orderItem);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbOrderItem orderItem){
		orderItemMapper.updateByPrimaryKey(orderItem);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbOrderItem findOne(String id){
		return orderItemMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			orderItemMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbOrderItem orderItem, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbOrderItemExample example=new TbOrderItemExample();
		Criteria criteria = example.createCriteria();
		
		if(orderItem!=null){			
						if(orderItem.getTitle()!=null && orderItem.getTitle().length()>0){
				criteria.andTitleLike("%"+orderItem.getTitle()+"%");
			}
			if(orderItem.getPicPath()!=null && orderItem.getPicPath().length()>0){
				criteria.andPicPathLike("%"+orderItem.getPicPath()+"%");
			}
			if(orderItem.getSellerId()!=null && orderItem.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+orderItem.getSellerId()+"%");
			}
	
		}
		
		Page<TbOrderItem> page= (Page<TbOrderItem>)orderItemMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
