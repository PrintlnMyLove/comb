package com.comb.school.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.comb.pojo.TbTeamUser;
import com.comb.publish.service.TeamUserService;

import entity.PageResult;
import entity.Result;
/**
 * 
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/teamUser")
public class TeamUserController {

	@Reference
	private TeamUserService teamUserService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbTeamUser> findAll(){			
		return teamUserService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
//	@RequestMapping("/findPage")
//	public PageResult  findPage(int page,int rows){			
//		return teamUserService.findPage(page, rows);
//	}
	
	/**
	 * 增加
	 * @param teamUser
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbTeamUser teamUser){
		try {
			teamUserService.add(teamUser);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param teamUser
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbTeamUser teamUser){
		try {
			teamUserService.update(teamUser);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbTeamUser findOne(String id){
		return teamUserService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String[] ids){
		try {
			teamUserService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbTeamUser teamUser, int page, int rows  ){
		return teamUserService.findPage(teamUser, page, rows);		
	}
	/**
	 * 更新状态
	 * @param teamId
	 * @param status
	 * @return
	 */
	@RequestMapping("/updateStatus")
	public Result updateStatus(String teamId, String status) {
		try {
			teamUserService.updateStatus(teamId, status);
			return new Result(true, "审核结果保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "审核结果保存失败");
		}
	}
	
}
