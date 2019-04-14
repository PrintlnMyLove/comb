package com.comb.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.comb.pojo.TbTeamUser;
import com.comb.publish.service.TeamUserService;


/**
 * 认证类
 * @author WangQingBang
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private TeamUserService teamUserService;
	
	public void setTeamUserService(TeamUserService teamUserService) {
		this.teamUserService = teamUserService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> grantAuths = new ArrayList<GrantedAuthority>();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		/**
		 * User:
		 * * 参数：
		 * 	* 1.用户名
		 *  * 2.密码
		 *  * 3.认证信息（角色）
		 */
		// 去数据库进行查询:
		TbTeamUser teamUser = teamUserService.findOne(username);
		if(teamUser != null) {
			if(teamUser.getStatus().equals("1")) {
				return new User(username, teamUser.getPassword(), grantAuths);
			}
			return null;
		}
		return null;
	}

	



}
