package com.comb.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.comb.pojo.TbSpecification;
import com.comb.pojo.TbSpecificationOption;

/**
 * 组合实体类
 * @author WangQingBang
 *
 */

public class Specification implements Serializable{
	// 规格实体
	private TbSpecification specification;
	// 规格选项集合
	private List<TbSpecificationOption> specificationOptionList;
	
	public TbSpecification getSpecification() {
		return specification;
	}
	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}
	public List<TbSpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}
	public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}
	
	
}
