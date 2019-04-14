package com.comb.publish.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.comb.mapper.TbSpecificationOptionMapper;
import com.comb.mapper.TbTypeTemplateMapper;
import com.comb.pojo.TbSpecificationOption;
import com.comb.pojo.TbSpecificationOptionExample;
import com.comb.pojo.TbTypeTemplate;
import com.comb.pojo.TbTypeTemplateExample;
import com.comb.pojo.TbTypeTemplateExample.Criteria;
import com.comb.publish.service.TypeTemplateService;

import entity.PageResult;

/**
 * 
 * @author WangQingBang
 *
 */
@Service(timeout=60000)
@Transactional	//事务注解
public class TypeTemplateServiceImpl implements TypeTemplateService {

	@Autowired
	private TbTypeTemplateMapper typeTemplateMapper;
	@Autowired
	TbSpecificationOptionMapper specificationOptionMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTypeTemplate> findAll() {
		return typeTemplateMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
//	@Override
//	public PageResult findPage(int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);		
//		Page<TbTypeTemplate> page=   (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
//	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTypeTemplate typeTemplate) {
		typeTemplateMapper.insert(typeTemplate);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTypeTemplate typeTemplate){
		typeTemplateMapper.updateByPrimaryKey(typeTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTypeTemplate findOne(Long id){
		return typeTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			typeTemplateMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTypeTemplateExample example=new TbTypeTemplateExample();
		Criteria criteria = example.createCriteria();
		
		if(typeTemplate!=null){			
						if(typeTemplate.getName()!=null && typeTemplate.getName().length()>0){
				criteria.andNameLike("%"+typeTemplate.getName()+"%");
			}
			if(typeTemplate.getSpecIds()!=null && typeTemplate.getSpecIds().length()>0){
				criteria.andSpecIdsLike("%"+typeTemplate.getSpecIds()+"%");
			}
			if(typeTemplate.getBrandIds()!=null && typeTemplate.getBrandIds().length()>0){
				criteria.andBrandIdsLike("%"+typeTemplate.getBrandIds()+"%");
			}
			if(typeTemplate.getCustomAttributeItems()!=null && typeTemplate.getCustomAttributeItems().length()>0){
				criteria.andCustomAttributeItemsLike("%"+typeTemplate.getCustomAttributeItems()+"%");
			}
	
		}
		
		Page<TbTypeTemplate> page= (Page<TbTypeTemplate>)typeTemplateMapper.selectByExample(example);
		//缓存处理
		saveToRedis();
		
		return new PageResult(page.getTotal(), page.getResult());
	}
		
	@Autowired	
	private RedisTemplate redisTemplate;	
	/**
	 * 将品牌列表和规格列表放入缓存中
	 */
	/**
	 * 将品牌列表与规格列表放入缓存
	 */
	private void saveToRedis(){
		List<TbTypeTemplate> templateList = findAll();
		for(TbTypeTemplate template:templateList){
			//得到品牌列表
			List brandList= JSON.parseArray(template.getBrandIds(), Map.class) ;
			redisTemplate.boundHashOps("brandList").put(template.getId(), brandList);
			
			//得到规格列表
			List<Map> specList = findSpecList(template.getId());
			redisTemplate.boundHashOps("specList").put(template.getId(), specList);
		}
		System.out.println("缓存品牌列表");
	}
	
	
	@Override
	public List<Map> selectOptionList() {
		return typeTemplateMapper.selectOptionList();
	}

		@Override
		public List<Map> findSpecList(Long id) {
			//根据id查询规格
			TbTypeTemplate typeTemplate = typeTemplateMapper.selectByPrimaryKey(id);
			// 获得规格的数据spec_ids
			List<Map> list = JSON.parseArray(typeTemplate.getSpecIds(), Map.class);
			// 将specIds的字符串转成JSON的List<Map>
			for (Map map : list) {
				// 根据规格的ID 查询规格选项的数据:
				// 设置查询条件:
				TbSpecificationOptionExample example = new TbSpecificationOptionExample();
				com.comb.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
				criteria.andSpecIdEqualTo(new Long((Integer)map.get("id")));
				
				
				List<TbSpecificationOption> options = specificationOptionMapper.selectByExample(example);
			
				map.put("options", options);//{"id":27,"text":"网络",options:[{id：xxx,optionName:移动2G}]}
			}
			return list;
		}
}
