package com.comb.publish.service;

import java.util.List;
import java.util.Map;

import com.comb.pojo.TbBrand;

import entity.PageResult;

/**
 * 品牌接口
 * @author WangQingBang
 *
 */
public interface BrandService {
	
	public List<TbBrand> findAll();
	
//	/**
//	 * 品牌分页
//	 * @param pageNum	当前页面
//	 * @param pageSize	每页记录数
//	 * @return
//	 */
//	public PageResult findPage(int pageNum, int pageSize);
	/**
	 * 增加
	 * @param brand
	 */
	public void add(TbBrand brand);
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public TbBrand findOne(Long id);
	/**
	 * 修改
	 * @param brand
	 */
	public void update(TbBrand brand);
	/**
	 * 复选多项删除
	 * @param ids
	 */
	public void delete(Long[] ids);
	/**
	 * 多条件查询，利用方法重载，新写一个方法
	 * @param brand
	 * @return
	 */
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize);
	/**
	 * 返回下拉列表数据
	 * @return
	 */
	public List<Map> selectOptionList();
}
