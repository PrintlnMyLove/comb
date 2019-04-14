package com.comb.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.comb.content.service.ContentService;
import com.comb.itemCat.service.ItemCatService;
import com.comb.pojo.TbContent;
import com.comb.pojo.TbItemCat;

/**
 * 控制层
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;
	
	@RequestMapping("/findByCategoryId")
	public List<TbContent> findByCategoryId(Long categoryId){
		return contentService.findByCategoryId(categoryId);
	}
	
	
	@Reference
	private ItemCatService itemCatService;

	
	@RequestMapping("/getItemCatList")
	public List<TbItemCat> getItemCatList(Long parentId) {
		return itemCatService.getItemCatList(parentId);
		
	}
}



