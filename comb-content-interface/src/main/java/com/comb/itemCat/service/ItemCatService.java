package com.comb.itemCat.service;
/**
 * 
 * @author WangQingBang
 *
 */

import java.util.List;

import com.comb.pojo.TbItemCat;

public interface ItemCatService {
	
	/**
	 * 获取商品分类列表
	 * @return
	 */
	public List<TbItemCat> getItemCatList(Long parentId);
}
