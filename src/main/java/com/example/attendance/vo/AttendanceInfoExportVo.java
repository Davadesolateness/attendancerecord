package com.example.attendance.vo;

import com.example.attendance.util.ExcelExport;

import java.math.BigDecimal;
import java.util.Date;

public class AttendanceInfoExportVo {
    /**
     * 人员代码
     */
    @ExcelExport("4A工号")
    private String userCode;

    /**
     * 考勤日期
     */
    @ExcelExport("考勤日期")
    private Date attendanceDate;

    /**
     * 人员姓名
     */
    @ExcelExport("姓名")
    private String userName;

    /**
     * 考勤状态
     */
    @ExcelExport("考勤状态")
    private String attendanceState;

    /**
     * 签到时间
     */
    @ExcelExport("签到时间")
    private Date signInTime;

    /**
     * 签退时间
     */
    @ExcelExport("签退时间")
    private Date signOutTime;

    /**
     * 打卡工时（小时）
     */
    @ExcelExport("打卡工时（小时）")
    private BigDecimal clockInHours;

    /**
     * 考勤核算工时（小时）
     */
    @ExcelExport("考勤核算工时（小时）")
    private BigDecimal calculationAttendanceHour;

    /**
     * 工作任务工时-TFS
     */
    @ExcelExport("工作任务工时-TFS")
    private BigDecimal workTaskHourTFS;

    /**
     * 工作任务工时-TFS  - 考勤核算工时（小时）  = 差值
     */
    @ExcelExport("差值")
    private BigDecimal differenceTFSAndCalculationHour;

    /**
     * 核算有效工时（小时）
     */
    @ExcelExport("核算有效工时（小时）")
    private BigDecimal calculationValidHour;

    /**
     * 超出时长
     */
    @ExcelExport("超出时长")
    private BigDecimal exceedTime;

    /**
     * 日期类型
     */
    @ExcelExport("日期类型")
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

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    @Override
    public String toString() {
        return "AttendanceInfo{" +
                "userCode='" + userCode + '\'' +
                ", attendanceDate=" + attendanceDate +
                ", userName='" + userName + '\'' +
                ", attendanceState='" + attendanceState + '\'' +
                ", signInTime=" + signInTime +
                ", signOutTime=" + signOutTime +
                ", clockInHours=" + clockInHours +
                ", calculationAttendanceHour=" + calculationAttendanceHour +
                ", workTaskHourTFS=" + workTaskHourTFS +
                ", calculationValidHour=" + calculationValidHour +
                ", DateType='" + dateType + '\'' +
                '}';
    }
}
