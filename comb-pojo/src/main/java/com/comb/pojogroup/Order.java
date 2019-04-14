package com.comb.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.comb.pojo.TbOrder;
import com.comb.pojo.TbOrderItem;

/**
 * 订单的组合实体类
 * @author WangQingBang
 *
 */
public class Order implements Serializable{
	private TbOrder order;
	private List<TbOrderItem> orderItem;
	private String nickName;	//店铺名称
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public TbOrder getOrder() {
		return order;
	}
	public void setOrder(TbOrder order) {
		this.order = order;
	}
	public List<TbOrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<TbOrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	
}
