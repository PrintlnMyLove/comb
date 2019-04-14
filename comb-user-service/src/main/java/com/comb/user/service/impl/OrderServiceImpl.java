package com.comb.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.comb.mapper.TbOrderItemMapper;
import com.comb.mapper.TbOrderMapper;
import com.comb.mapper.TbTeamUserMapper;
import com.comb.pojo.TbOrder;
import com.comb.pojo.TbOrderExample;
import com.comb.pojo.TbOrderExample.Criteria;
import com.comb.pojo.TbOrderItem;
import com.comb.pojo.TbOrderItemExample;
import com.comb.pojo.TbTeamUser;
import com.comb.pojogroup.Order;
import com.comb.user.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.tools.javah.resources.l10n;

import entity.PageResult;

/**
 * 
 * @author WangQingBang
 *
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private TbOrderMapper orderMapper;
	
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	
	@Autowired
	private TbTeamUserMapper teamUserMapper;
	
	/**
	 * 查找订单列表
	 */
	@Override
	public List<Order> findOrderList(String username) {
		List<Order> orderList = new ArrayList<>();
		Order order;
		TbOrderExample example_order = new TbOrderExample();
		Criteria criteria_order = example_order.createCriteria();
		criteria_order.andUserIdEqualTo(username);
		
		List<TbOrder> listTemp = orderMapper.selectByExample(example_order);
		if(listTemp != null) {
			for(TbOrder tbOrder : listTemp) {
				
				order = new Order();
				/**
				 * 添加order列表
				 */
				order.setOrder(tbOrder);
				/**
				 * 添加orderItem中列表
				 */
				TbOrderItemExample example = new TbOrderItemExample();
				com.comb.pojo.TbOrderItemExample.Criteria criteria = example.createCriteria();
				criteria.andOrderIdEqualTo(tbOrder.getOrderId());
				order.setOrderItem(orderItemMapper.selectByExample(example));
				/**
				 * 添加店铺名称
				 */
				order.setNickName(teamUserMapper.selectByPrimaryKey(order.getOrder().getSellerId()).getNickName());
				orderList.add(order);
			}	
		}
		return orderList;
	}

	@Override
	public void ensureOrder(String id) {
		TbOrder order = orderMapper.selectByPrimaryKey(id);
		order.setStatus("5");
		order.setEndTime(new Date());
		orderMapper.updateByPrimaryKey(order);
		TbOrder order2 = new TbOrder();
		
	}

	/**
	 * 查询单个实体
	 */
	@Override
	public Order findOrder(String id) {
		Order order = new Order();
		order.setOrder(orderMapper.selectByPrimaryKey(id));
		
		TbOrderItemExample example = new TbOrderItemExample();
		com.comb.pojo.TbOrderItemExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(id);
		order.setOrderItem(orderItemMapper.selectByExample(example));
		return order;
	}
	
	
	
	
	@Override
	public PageResult findPage(TbOrder order, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbOrderExample example=new TbOrderExample();
		Criteria criteria = example.createCriteria();
		
		if(order!=null){			
						if(order.getPaymentType()!=null && order.getPaymentType().length()>0){
				criteria.andPaymentTypeLike("%"+order.getPaymentType()+"%");
			}
			if(order.getPostFee()!=null && order.getPostFee().length()>0){
				criteria.andPostFeeLike("%"+order.getPostFee()+"%");
			}
			if(order.getStatus()!=null && order.getStatus().length()>0){
				criteria.andStatusLike("%"+order.getStatus()+"%");
			}
			if(order.getShippingName()!=null && order.getShippingName().length()>0){
				criteria.andShippingNameLike("%"+order.getShippingName()+"%");
			}
			if(order.getShippingCode()!=null && order.getShippingCode().length()>0){
				criteria.andShippingCodeLike("%"+order.getShippingCode()+"%");
			}
			if(order.getUserId()!=null && order.getUserId().length()>0){
				criteria.andUserIdLike("%"+order.getUserId()+"%");
			}
			if(order.getBuyerMessage()!=null && order.getBuyerMessage().length()>0){
				criteria.andBuyerMessageLike("%"+order.getBuyerMessage()+"%");
			}
			if(order.getBuyerNick()!=null && order.getBuyerNick().length()>0){
				criteria.andBuyerNickLike("%"+order.getBuyerNick()+"%");
			}
			if(order.getBuyerRate()!=null && order.getBuyerRate().length()>0){
				criteria.andBuyerRateLike("%"+order.getBuyerRate()+"%");
			}
			if(order.getReceiverAreaName()!=null && order.getReceiverAreaName().length()>0){
				criteria.andReceiverAreaNameLike("%"+order.getReceiverAreaName()+"%");
			}
			if(order.getReceiverMobile()!=null && order.getReceiverMobile().length()>0){
				criteria.andReceiverMobileLike("%"+order.getReceiverMobile()+"%");
			}
			if(order.getReceiverZipCode()!=null && order.getReceiverZipCode().length()>0){
				criteria.andReceiverZipCodeLike("%"+order.getReceiverZipCode()+"%");
			}
			if(order.getReceiver()!=null && order.getReceiver().length()>0){
				criteria.andReceiverLike("%"+order.getReceiver()+"%");
			}
			if(order.getInvoiceType()!=null && order.getInvoiceType().length()>0){
				criteria.andInvoiceTypeLike("%"+order.getInvoiceType()+"%");
			}
			if(order.getSourceType()!=null && order.getSourceType().length()>0){
				criteria.andSourceTypeLike("%"+order.getSourceType()+"%");
			}
			if(order.getSellerId()!=null && order.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+order.getSellerId()+"%");
			}
	
		}
		
		Page<TbOrder> page= (Page<TbOrder>)orderMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}


	
}
