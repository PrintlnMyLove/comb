package com.comb.pojo;

import java.io.Serializable;

public class TbTeamCheck implements Serializable{
    private String teamId;

    private Long monthOrder;

    private Long yearOrder;

    private Long pv;

    private Long star;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public Long getMonthOrder() {
        return monthOrder;
    }

    public void setMonthOrder(Long monthOrder) {
        this.monthOrder = monthOrder;
    }

    public Long getYearOrder() {
        return yearOrder;
    }

    public void setYearOrder(Long yearOrder) {
        this.yearOrder = yearOrder;
    }

    public Long getPv() {
        return pv;
    }

    public void setPv(Long pv) {
        this.pv = pv;
    }

    public Long getStar() {
        return star;
    }

    public void setStar(Long star) {
        this.star = star;
    }
}