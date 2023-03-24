package com.example.attendance.vo;

import com.example.attendance.util.ExcelImport;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: 导入的vo数据
 * @author dongzhibo
 * @date 2023/3/17 18:12
 * @version 1.0
 */
public class AttendanceInfoVo {


    private int rowNum;
    /**
     * 考勤号1
     */
    @ExcelImport(value = "考勤号1")
    private String attendanceCode1;

    /**
     * 考勤号2
     */
    @ExcelImport("考勤号2")
    private String attendanceCode2;

    /**
     * 4A工号
     */
    @ExcelImport(value = "4A工号",unique = true)
    private String userCode;

    /**
     * 系统名称
     */
    @ExcelImport("系统名称")
    private String systemName;

    /**
     * 姓名
     */
    @ExcelImport("姓名")
    private String userName;

    /**
     * 考勤状态
     */
    @ExcelImport("考勤状态")
    private String attendanceState;

    /**
     * 考勤日期
     */
    @ExcelImport(value = "考勤日期",unique = true)
    private Date attendanceDate;

    /**
     * 签到时间
     */
    @ExcelImport("签到时间")
    private Date signInTime;

    /**
     * 签退时间
     */
    @ExcelImport("签退时间")
    private Date signOutTime;

    /**
     * 打卡工时（小时）
     */
    @ExcelImport("打卡工时（小时）")
    private BigDecimal clockInHours;

    /**
     * 考勤核算工时（小时）
     */
    @ExcelImport("考勤核算工时（小时）")
    private BigDecimal calculationAttendanceHour;

    /**
     * 工作任务工时-考勤
     */
    @ExcelImport("工作任务工时-考勤")
    private BigDecimal workTaskHour;

    /**
     * 工作任务工时-TFS
     */
    @ExcelImport("工作任务工时-TFS")
    private BigDecimal workTaskHourTFS;

    /**
     * 核算有效工时（小时）
     */
    @ExcelImport("核算有效工时（小时）")
    private BigDecimal calculationValidHour;

    /**
     * 出勤天数（天）
     */
    @ExcelImport("出勤天数（天）")
    private String attendanceDays;


    /**
     * 超出时长（小时）
     */
    @ExcelImport("超出时长（小时）")
    private BigDecimal exceedTime;

    /**
     * 未打卡请假
     */
    @ExcelImport("未打卡请假")
    private String noClockInLeave;

    /**
     * 已打卡中途请假
     */
    @ExcelImport("已打卡中途请假")
    private String clockInMidLeave;

    /**
     * 工作日/节假日
     */
    @ExcelImport("工作日/节假日")
    private String DateType;

    /**
     * 数据来源
     */
    @ExcelImport("数据来源")
    private String dataSources;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getAttendanceCode1() {
        return attendanceCode1;
    }

    public void setAttendanceCode1(String attendanceCode1) {
        this.attendanceCode1 = attendanceCode1;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAttendanceCode2() {
        return attendanceCode2;
    }

    public void setAttendanceCode2(String attendanceCode2) {
        this.attendanceCode2 = attendanceCode2;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
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

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
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

    public BigDecimal getCalculationValidHour() {
        return calculationValidHour;
    }

    public void setCalculationValidHour(BigDecimal calculationValidHour) {
        this.calculationValidHour = calculationValidHour;
    }

    public String getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(String attendanceDays) {
        this.attendanceDays = attendanceDays;
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
        return DateType;
    }

    public void setDateType(String dateType) {
        DateType = dateType;
    }

    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources;
    }
}
