package com.comb.publish.service.impl;



import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.comb.mapper.TbTeamCheckMapper;
import com.comb.mapper.TbTeamUserMapper;
import com.comb.pojo.TbTeamCheck;
import com.comb.pojo.TbTeamUser;
import com.comb.pojo.TbTeamUserExample;
import com.comb.pojo.TbTeamUserExample.Criteria;
import com.comb.publish.service.TeamUserService;

import entity.PageResult;

/**
 * 服务实现层
 * @author WangQingBang
 *
 */
@Service(timeout=60000)
@Transactional	//事务注解
public class TeamUserServiceImpl implements TeamUserService {

	@Autowired
	private TbTeamUserMapper teamUserMapper;
	
	@Autowired
	private TbTeamCheckMapper teamCheckMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTeamUser> findAll() {
		return teamUserMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
//	@Override
//	public PageResult findPage(int pageNum, int pageSize) {
//		PageHelper.startPage(pageNum, pageSize);		
//		Page<TbTeamUser> page=   (Page<TbTeamUser>) teamUserMapper.selectByExample(null);
//		return new PageResult(page.getTotal(), page.getResult());
//	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTeamUser teamUser) {
		teamUser.setStatus("0");	//默认状态
		teamUser.setCreateTime(new Date());	//申请日期
		teamUserMapper.insert(teamUser);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTeamUser teamUser){
		teamUserMapper.updateByPrimaryKey(teamUser);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTeamUser findOne(String id){
		return teamUserMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(String[] ids) {
		for(String id:ids){
			teamUserMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTeamUser teamUser, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTeamUserExample example=new TbTeamUserExample();
		Criteria criteria = example.createCriteria();
		
		if(teamUser!=null){			
						if(teamUser.getSellerId()!=null && teamUser.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+teamUser.getSellerId()+"%");
			}
			if(teamUser.getTeamName()!=null && teamUser.getTeamName().length()>0){
				criteria.andTeamNameLike("%"+teamUser.getTeamName()+"%");
			}
			if(teamUser.getNickName()!=null && teamUser.getNickName().length()>0){
				criteria.andNickNameLike("%"+teamUser.getNickName()+"%");
			}
			if(teamUser.getPassword()!=null && teamUser.getPassword().length()>0){
				criteria.andPasswordLike("%"+teamUser.getPassword()+"%");
			}
			if(teamUser.getEmail()!=null && teamUser.getEmail().length()>0){
				criteria.andEmailLike("%"+teamUser.getEmail()+"%");
			}
			if(teamUser.getStatus()!=null && teamUser.getStatus().length()>0){
				criteria.andStatusLike("%"+teamUser.getStatus()+"%");
			}
			if(teamUser.getAddressDetail()!=null && teamUser.getAddressDetail().length()>0){
				criteria.andAddressDetailLike("%"+teamUser.getAddressDetail()+"%");
			}
			if(teamUser.getLinkmanName()!=null && teamUser.getLinkmanName().length()>0){
				criteria.andLinkmanNameLike("%"+teamUser.getLinkmanName()+"%");
			}
			if(teamUser.getLinkmanQq()!=null && teamUser.getLinkmanQq().length()>0){
				criteria.andLinkmanQqLike("%"+teamUser.getLinkmanQq()+"%");
			}
			if(teamUser.getLinkmanMobile()!=null && teamUser.getLinkmanMobile().length()>0){
				criteria.andLinkmanMobileLike("%"+teamUser.getLinkmanMobile()+"%");
			}
			if(teamUser.getLinkmanEmail()!=null && teamUser.getLinkmanEmail().length()>0){
				criteria.andLinkmanEmailLike("%"+teamUser.getLinkmanEmail()+"%");
			}
			if(teamUser.getMumber()!=null && teamUser.getMumber().length()>0){
				criteria.andMumberLike("%"+teamUser.getMumber()+"%");
			}
			if(teamUser.getLogoPic()!=null && teamUser.getLogoPic().length()>0){
				criteria.andLogoPicLike("%"+teamUser.getLogoPic()+"%");
			}
			if(teamUser.getBrief()!=null && teamUser.getBrief().length()>0){
				criteria.andBriefLike("%"+teamUser.getBrief()+"%");
			}
			if(teamUser.getLeaderId()!=null && teamUser.getLeaderId().length()>0){
				criteria.andLeaderIdLike("%"+teamUser.getLeaderId()+"%");
			}
	
		}
		
		Page<TbTeamUser> page= (Page<TbTeamUser>)teamUserMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public void updateStatus(String teamId, String status) {
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(teamId);
			teamUser.setStatus(status);
			teamUserMapper.updateByPrimaryKey(teamUser);
			
		}

		@Override
		public boolean isPassword(String id, String oldPassword) {
			
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(id);
			if(teamUser.getPassword().equals(oldPassword)) {
				return true;
			}
			return false;
			
		}

		@Override
		public void updataPassword(String id, String password) {
			TbTeamUser teamUser = teamUserMapper.selectByPrimaryKey(id);
			teamUser.setPassword(password);
			teamUserMapper.updateByPrimaryKey(teamUser);	
		}

		
		@Override
		public TbTeamCheck showPerformance(String loginName) {
			TbTeamCheck teamCheck = teamCheckMapper.selectByPrimaryKey(loginName);
			return teamCheck;
		}
	
}
