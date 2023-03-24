package com.example.attendance.entity;

import org.apache.ibatis.annotations.Mapper;

/**
 * @description: TODO
 * @author dongzhibo
 * @date 2023/3/20 16:26
 * @version 1.0
 */
@Mapper
public class PersonInfo {

    /**
     * 人员代码
     */
    private String userCode;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 人员姓名
     */
    private String homeSystem;

    /**
     * 项目团队组长代码
     */
    private String projectTeamLeaderCode;

    /**
     * 项目团队组长名称
     */
    private String projectTeamLeaderName;

    /**
     * 职能团队组长代码
     */
    private String functionTeamLeaderCode;

    /**
     * 职能团队组长名称
     */
    private String functionTeamLeaderName;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHomeSystem() {
        return homeSystem;
    }

    public void setHomeSystem(String homeSystem) {
        this.homeSystem = homeSystem;
    }

    public String getProjectTeamLeaderCode() {
        return projectTeamLeaderCode;
    }

    public void setProjectTeamLeaderCode(String projectTeamLeaderCode) {
        this.projectTeamLeaderCode = projectTeamLeaderCode;
    }

    public String getProjectTeamLeaderName() {
        return projectTeamLeaderName;
    }

    public void setProjectTeamLeaderName(String projectTeamLeaderName) {
        this.projectTeamLeaderName = projectTeamLeaderName;
    }

    public String getFunctionTeamLeaderCode() {
        return functionTeamLeaderCode;
    }

    public void setFunctionTeamLeaderCode(String functionTeamLeaderCode) {
        this.functionTeamLeaderCode = functionTeamLeaderCode;
    }

    public String getFunctionTeamLeaderName() {
        return functionTeamLeaderName;
    }

    public void setFunctionTeamLeaderName(String functionTeamLeaderName) {
        this.functionTeamLeaderName = functionTeamLeaderName;
    }
}
