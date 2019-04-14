package com.comb.publish.service;


import java.util.List;
import com.comb.pojo.TbTeamUser;

import entity.PageResult;
/**
 * 服务层接口
 * @author WangQingBang
 *
 */
public interface TeamUserService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbTeamUser> findAll();
	
	
//	/**
//	 * 返回分页列表
//	 * @return
//	 */
//	public PageResult findPage(int pageNum,int pageSize);
//	
	
	/**
	 * 增加
	*/
	public void add(TbTeamUser teamUser);
	
	
	/**
	 * 修改
	 */
	public void update(TbTeamUser teamUser);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbTeamUser findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbTeamUser teamUser, int pageNum,int pageSize);
	/**
	 * 更新状态
	 * @param teamId
	 * @param status
	 */
	public void updateStatus(String teamId, String status);
	
	/**
	 * 判断输入密码是否正确
	 * @param id
	 * @param oldPassword
	 * @return
	 */
	public boolean isPassword(String id,String oldPassword);
	
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 */
	public void updataPassword(String id, String password);
}
