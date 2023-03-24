package com.example.attendance.entity;

import com.example.attendance.util.ExcelImport;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author dongzhibo
 * @version 1.0
 * @description: PO 考勤信息
 * @date 2023/3/17 19:30
 */
public class AttendanceInfo {
    /**
     * 人员代码
     */
    private String userCode;

    /**
     * 考勤日期
     */
    private Date attendanceDate;

    /**
     * 人员姓名
     */
    private String userName;

    /**
     * 考勤状态
     */
    private String attendanceState;

    /**
     * 签到时间
     */
    private Date signInTime;

    /**
     * 签退时间
     */
    private Date signOutTime;

    /**
     * 打卡工时（小时）
     */
    private BigDecimal clockInHours;

    /**
     * 考勤核算工时（小时）
     */
    private BigDecimal calculationAttendanceHour;

    /**
     * 工作任务工时-考勤
     */
    private BigDecimal workTaskHour;

    /**
     * 工作任务工时-TFS
     */
    private BigDecimal workTaskHourTFS;

    /**
     * 工作任务工时-TFS  - 考勤核算工时（小时）  = 差值
     */
    private BigDecimal differenceTFSAndCalculationHour;

    /**
     * 核算有效工时（小时）
     */
    private BigDecimal calculationValidHour;

    /**
     * 超出时长
     */
    private BigDecimal exceedTime;

    /**
     * 未打卡请假
     */
    private String noClockInLeave;

    /**
     * 已打卡中途请假
     */
    private String clockInMidLeave;

    /**
     * 日期类型
     */
    private String dateType;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignOutTime() {
        return signOutTime;
    }

    public void setSignOutTime(Date signOutTime) {
        this.signOutTime = signOutTime;
    }

    public BigDecimal getClockInHours() {
        return clockInHours;
    }

    public void setClockInHours(BigDecimal clockInHours) {
        this.clockInHours = clockInHours;
    }

    public BigDecimal getCalculationAttendanceHour() {
        return calculationAttendanceHour;
    }

    public void setCalculationAttendanceHour(BigDecimal calculationAttendanceHour) {
        this.calculationAttendanceHour = calculationAttendanceHour;
    }

    public BigDecimal getWorkTaskHour() {
        return workTaskHour;
    }

    public void setWorkTaskHour(BigDecimal workTaskHour) {
        this.workTaskHour = workTaskHour;
    }

    public BigDecimal getWorkTaskHourTFS() {
        return workTaskHourTFS;
    }

    public void setWorkTaskHourTFS(BigDecimal workTaskHourTFS) {
        this.workTaskHourTFS = workTaskHourTFS;
    }

    public BigDecimal getDifferenceTFSAndCalculationHour() {
        return differenceTFSAndCalculationHour;
    }

    public void setDifferenceTFSAndCalculationHour(BigDecimal differenceTFSAndCalculationHour) {
        this.differenceTFSAndCalculationHour = differenceTFSAndCalculationHour;
    }

    public BigDecimal getCalculationValidHour() {
        return calculationValidHour;
    }

    public void setCalculationValidHour(BigDecimal calculationValidHour) {
        this.calculationValidHour = calculationValidHour;
    }

    public BigDecimal getExceedTime() {
        return exceedTime;
    }

    public void setExceedTime(BigDecimal exceedTime) {
        this.exceedTime = exceedTime;
    }

    public String getNoClockInLeave() {
        return noClockInLeave;
    }

    public void setNoClockInLeave(String noClockInLeave) {
        this.noClockInLeave = noClockInLeave;
    }

    public String getClockInMidLeave() {
        return clockInMidLeave;
    }

    public void setClockInMidLeave(String clockInMidLeave) {
        this.clockInMidLeave = clockInMidLeave;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }


}
