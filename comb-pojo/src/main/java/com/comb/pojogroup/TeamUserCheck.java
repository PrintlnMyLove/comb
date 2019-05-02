package com.comb.pojogroup;

import java.io.Serializable;

import com.comb.pojo.TbTeamCheck;
import com.comb.pojo.TbTeamUser;

public class TeamUserCheck implements Serializable{
	private TbTeamUser teamUser;
	private TbTeamCheck teamCheck;
	public TbTeamUser getTeamUser() {
		return teamUser;
	}
	public void setTeamUser(TbTeamUser teamUser) {
		this.teamUser = teamUser;
	}
	public TbTeamCheck getTeamCheck() {
		return teamCheck;
	}
	public void setTeamCheck(TbTeamCheck teamCheck) {
		this.teamCheck = teamCheck;
	}
}
