package com.comb.search.service.impl;

import java.util.List;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.comb.pojo.TbItem;
import com.comb.pojogroup.TbItem_solr;
import com.comb.search.service.ItemSearchService;

@Component
public class itemSearchListener implements MessageListener{
	
//	@Autowired
//	private ItemSearchService itemSearchService;
	
	@Autowired
	private SolrTemplate solrTemplate;
	
	@Override
	public void onMessage(Message message) {
		

		try {
			TextMessage textMessage=(TextMessage)message;			
			String text = textMessage.getText();
			List<TbItem_solr> list = JSON.parseArray(text,TbItem_solr.class);
			for(TbItem_solr item:list){
				System.out.println(item.getId()+" "+item.getTitle());
				Map specMap= JSON.parseObject(item.getSpec());//将spec字段中的json字符串转换为map
				item.setSpecMap(specMap);//给带注解的字段赋值
			}			
			//itemSearchService.importList(list);//导入
			
			solrTemplate.saveBeans(list);
			solrTemplate.commit();
			
			System.out.println("成功导入到索引库");
			
		} catch (JMSException e) {
			
			e.printStackTrace();
		}
		
	}

}
