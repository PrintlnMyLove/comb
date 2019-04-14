package com.comb.pojo;

public class TbApplyTeamWithBLOBs extends TbApplyTeam {
    private String teamContent;

    private byte[] filedata;

    private String teamFeedback;

    public String getTeamContent() {
        return teamContent;
    }

    public void setTeamContent(String teamContent) {
        this.teamContent = teamContent == null ? null : teamContent.trim();
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }

    public String getTeamFeedback() {
        return teamFeedback;
    }

    public void setTeamFeedback(String teamFeedback) {
        this.teamFeedback = teamFeedback == null ? null : teamFeedback.trim();
    }
}