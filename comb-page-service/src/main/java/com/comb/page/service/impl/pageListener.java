package com.comb.page.service.impl;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comb.page.service.ItemPageService;
/**
 * 静态页面生成
 * @author WangQingBang
 *
 */
@Component
public class pageListener implements MessageListener{

	@Autowired
	private ItemPageService itemPageService;
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage=(TextMessage)message;
		try {
			String text = textMessage.getText();
			System.out.println("接收到消息："+text);
			boolean b = itemPageService.genItemHtml(Long.parseLong(text));
		} catch (Exception e) {
			e.printStackTrace();
		}		

		
	}

}
