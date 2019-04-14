package com.comb.school.controller;


import java.util.Arrays;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.zookeeper.server.SessionTracker.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.comb.pojo.TbGoods;
import com.comb.pojo.TbItem;
import com.comb.pojogroup.Goods;
import com.comb.publish.service.GoodsService;

import entity.PageResult;
import entity.Result;
/**
 * 
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
//	@RequestMapping("/findPage")
//	public PageResult  findPage(int page,int rows){			
//		return goodsService.findPage(page, rows);
//	}
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
//	@RequestMapping("/add")
//	public Result add(@RequestBody TbGoods goods){
//		try {
//			goodsService.add(goods);
//			return new Result(true, "增加成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new Result(false, "增加失败");
//		}
//	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Goods goods){
		try {
			goodsService.update(goods);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	

	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Goods findOne(Long id){
		return goodsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination queueSolrDeleteDestination1;
	
	@RequestMapping("/delete")
	public Result delete(final Long [] ids){
		try {
			goodsService.delete(ids);
			//从索引库中删除
			//itemSearchService.deleteByGoodsIds(Arrays.asList(ids));
			jmsTemplate.send(queueSolrDeleteDestination1, new MessageCreator() {

			@Override
			public Message createMessage(javax.jms.Session session) throws JMSException {
				return session.createObjectMessage(ids);
			}		
		});	
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
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
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		return goodsService.findPage(goods, page, rows);		
	}
	
//	@Reference(timeout=100000)
//	private ItemSearchService itemSearchService;
	
//	@Reference(timeout=100000)
//	private ItemPageService itemPageService;
	
	@Autowired
	private Destination topicPageDestination;
	
	@RequestMapping("/updateStatus")
	public Result updateStatus(Long[] ids,String status){
		try {
			goodsService.updateStatus(ids, status);	
			if("1".equals(status)) {
				//审核成功后，生成商品详细页
				for(final Long goodsId : ids) {
//					itemPageService.genItemHtml(goodsId);
					//生成静态页面
					jmsTemplate.send(topicPageDestination, new MessageCreator() {
						@Override
						public Message createMessage(javax.jms.Session session) throws JMSException {	
							return session.createTextMessage(goodsId+"");
						}
					});
				}
				
			}
			
			return new Result(true, "审核商品成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改状态失败");
		}
	}
	
	/**
	 * 测试使用
	 * @param goodsId
	 */
//	
//	@RequestMapping("/genHtml")
//	public void genHtml(Long goodsId) {
//		itemPageService.genItemHtml(goodsId);
//	}
	
	
	//使用消息方式解耦
		@RequestMapping("/updateMarketable")
		public Result Maketstatus(final Long[] ids, String status) {
			try {
				goodsService.updateMarketable(ids, status);
				
					
				return new Result(true, "商品已下架"); 
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改状态失败");
			}
		}
}
