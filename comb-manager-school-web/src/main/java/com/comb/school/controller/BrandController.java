package com.comb.school.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.comb.pojo.TbBrand;
import com.comb.publish.service.BrandService;

import entity.PageResult;
import entity.Result;

/**
 * 品牌控制器
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	//Service接口
	@Reference
	private BrandService brandService;
	
	//查询所有品牌
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
//	//分页函数
//	@RequestMapping("/findPage")
//	public PageResult findPage(int page, int size) {
//		return brandService.findPage(page, size);
//	}
	
	//增加品牌
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		try {
			brandService.add(brand);
			return new Result(true, "新增品牌成功！");
		} catch (Exception e) {
			return new Result(false, "增加品牌失败！");
		}
	}
	//查询
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}
	//更新
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		try {
			brandService.update(brand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			return new Result(false, "修改失败");
		}
	}
	//复选删除
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			return new Result(false, "删除失败");
		}
	}
	//多条件组合查询
	@RequestMapping("/search")
	public PageResult serch(@RequestBody TbBrand brand,int page, int rows) {
		return brandService.findPage(brand, page, rows);
	}
	//下拉列表查询
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}
}
