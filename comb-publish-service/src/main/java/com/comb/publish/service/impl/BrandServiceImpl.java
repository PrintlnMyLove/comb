package com.comb.publish.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.comb.mapper.TbBrandMapper;
import com.comb.pojo.TbBrand;
import com.comb.pojo.TbBrandExample;
import com.comb.pojo.TbBrandExample.Criteria;
import com.comb.publish.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import entity.PageResult;
/**
 * 实现品牌功能
 * @author WangQingBang
 *
 */
@Service(timeout=60000)
@Transactional	//事务注解
public class BrandServiceImpl implements BrandService{

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		
		return brandMapper.selectByExample(null);
	}

//	@Override
//	public PageResult findPage(int pageNum, int pageSize) {
//		/**
//		 * 使用Mybatis的分页插件
//		 */
//		PageHelper.startPage(pageNum, pageSize);
//		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
//	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
		
	}

	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();;
		if(brand != null) {
			if(brand.getName() != null && brand.getName().length() > 0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getContent() != null && brand.getContent().length() > 0) {
				criteria.andContentLike("%"+brand.getContent()+"%");
			}
			if(brand.getLeader() != null && brand.getLeader().length() > 0) {
				criteria.andLeaderLike("%"+brand.getLeader()+"%");
			}
		}
		
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example );
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		return brandMapper.selectOptionList();
	}
	
}
