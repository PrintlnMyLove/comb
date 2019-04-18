package com.comb.search.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.comb.search.service.ItemSearchService;

/**
 * 
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/itemsearch")
public class ItemSearchController {
	
	@Reference
	private ItemSearchService itemSearchService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@RequestMapping("/search")
	public Map search(@RequestBody Map searchMap){
		
		return itemSearchService.search(searchMap);
		
	}
	
	@RequestMapping("/pvConunt")
	public void pvConunt(Long goodsId) {
		
		if(util.CookieUtil.getCookieValue(request,"count", "UTF-8") == null) {
			util.CookieUtil.setCookie(request, response, "count", "aaaaa", 3600*10, "UTF-8");
		}else {
			return;
		}
		try {
			itemSearchService.pvConunt(goodsId);
		} catch (Exception e) {
			
		}
		
	}

}
