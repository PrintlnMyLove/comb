package com.comb.publish.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.comb.mapper.TbSpecificationMapper;
import com.comb.mapper.TbSpecificationOptionMapper;
import com.comb.pojo.TbSpecification;
import com.comb.pojo.TbSpecificationExample;
import com.comb.pojo.TbSpecificationExample.Criteria;
import com.comb.pojo.TbSpecificationOption;
import com.comb.pojo.TbSpecificationOptionExample;
import com.comb.pojogroup.Specification;
import com.comb.publish.service.SpecificationService;

import entity.PageResult;

/**
 * 服务实现层
 * @author WangQingBang
 *
 */
@Service(timeout=60000)
@Transactional	//事务注解
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;
	
	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
//	@Override
//	public PageResult findPage(int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);		
//		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
//	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		// 保存规格
		specificationMapper.insert(specification.getSpecification());
		// 保存规格选项
		for(TbSpecificationOption specificationOption: specification.getSpecificationOptionList()){
			// 设置规格的ID:
			specificationOption.setSpecId(specification.getSpecification().getId());
			
			specificationOptionMapper.insert(specificationOption);
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		// 修改规格
				specificationMapper.updateByPrimaryKey(specification.getSpecification());
				
				// 先删除规格选项，再添加规格选项
				TbSpecificationOptionExample example = new TbSpecificationOptionExample();
				com.comb.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
				criteria.andSpecIdEqualTo(specification.getSpecification().getId());
				specificationOptionMapper.deleteByExample(example);
				
				// 保存规格选项
				for(TbSpecificationOption specificationOption: specification.getSpecificationOptionList()){
					// 设置规格的ID:
					specificationOption.setSpecId(specification.getSpecification().getId());
					
					specificationOptionMapper.insert(specificationOption);
				}
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		Specification specification = new Specification();
		specification.setSpecification(specificationMapper.selectByPrimaryKey(id));
		
		
		//获取规格选项的列表
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		com.comb.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> specificationOptionList = specificationOptionMapper.selectByExample(example);
		specification.setSpecificationOptionList(specificationOptionList);
		return specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
			//再删规格表数据！
			// 删除规格选项:
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			com.comb.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public List<Map> selectOptionList() {
			return specificationMapper.selectOptionList();
		}
	
}
