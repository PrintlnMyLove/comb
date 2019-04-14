package com.comb.itemCatService.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.comb.itemCat.service.ItemCatService;
import com.comb.mapper.TbItemCatMapper;
import com.comb.pojo.TbItemCat;
import com.comb.pojo.TbItemCatExample;
import com.comb.pojo.TbItemCatExample.Criteria;

/**
 * 
 * @author WangQingBang
 *
 */
@Service(timeout=60000)
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	/**
	 * 根据parentId查询
	 */
	@Override
	public List<TbItemCat> getItemCatList(Long parentId) {
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		return itemCatMapper.selectByExample(example);
	} 
	
	

	
	

}
