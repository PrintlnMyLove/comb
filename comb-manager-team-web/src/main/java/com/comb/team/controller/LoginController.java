package com.comb.team.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.comb.pojo.TbTeamCheck;
import com.comb.publish.service.TeamUserService;
/**
 * 
 * @author WangQingBang
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Reference
	private TeamUserService teamUserService;
	
	@RequestMapping("/name")
	public Map name(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map map=new HashMap<>();
		map.put("loginName", name);
		return map;		
	}
	
	@RequestMapping("/performance")
	public TbTeamCheck showPerformance() {
		Map<String,String> map = name();
		String loginName = map.get("loginName");
		return teamUserService.showPerformance(loginName);
	}

}
