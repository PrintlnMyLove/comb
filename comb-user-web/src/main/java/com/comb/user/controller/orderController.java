package com.comb.user.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.comb.pojo.TbOrder;
import com.comb.pojogroup.Order;
import com.comb.user.service.OrderService;

import entity.PageResult;
import entity.Result;

/**
 * 
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/order")
public class orderController {

	@Reference
	private OrderService orderService;
	
	@RequestMapping("/findOrderList")
	public List<Order> findOrderList(){			
		//获取当前登录人账号
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return orderService.findOrderList(username);
	}
	
	@RequestMapping("/ensure")
	public Result ensureOrder(String id) {
		try {
			orderService.ensureOrder(id);
			return new Result(true, "确认收货成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "确认收货失败！");
		}
	}
	
	
	
	
	/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbOrder order, int page, int rows  ){
		return orderService.findPage(order, page, rows);		
	}
	
	/**
	 * 查询单个实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOrder")
	public Order findOrder(String id){
		return orderService.findOrder(id);		
	}
}
