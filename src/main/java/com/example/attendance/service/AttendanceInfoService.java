package com.example.attendance.service;

import com.example.attendance.dao.AttendanceInfoDao;
import com.example.attendance.entity.AttendanceInfo;
import com.example.attendance.util.CommonUtil;
import com.example.attendance.vo.AttendanceInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dongzhibo
 * @version 1.0
 * @description: TODO
 * @date 2023/3/17 20:14
 */
@Service
public class AttendanceInfoService {

    @Autowired
    private AttendanceInfoDao attendanceInfoDao;

    @Autowired
    private PersonInfoService personInfoService;

    /**
     * 根据人员代码获取人员信息数据
     *
     * @param userCode 人员代码
     * @return
     * @author dongzhibo
     * @date 2023/3/21 10:59
     */
    public List<AttendanceInfo> getAttendanceInfo(String userCode, boolean flag) {
        Set<String> userCodeSet = new HashSet<>();
        personInfoService.getGroupPersonByProjectCode(userCode, userCodeSet);
        List<AttendanceInfo> attendanceInfoList = attendanceInfoDao.queryAttendanceInfoListByUserCode(userCodeSet);
        List<AttendanceInfo> attendanceInfoErrorList = this.getAttendanceInfoByRule(attendanceInfoList, flag);
        return attendanceInfoErrorList;
    }

    public int savaAttendanceInfo(List<AttendanceInfoVo> attendanceInfoVoList) {
        int result = 0;
        List<AttendanceInfo> attendanceInfoList = new ArrayList<>(attendanceInfoVoList.size());
        for (AttendanceInfoVo attendanceInfoVo : attendanceInfoVoList) {
            AttendanceInfo attendanceInfo = new AttendanceInfo();
            BeanUtils.copyProperties(attendanceInfoVo, attendanceInfo);
            if (attendanceInfo.getWorkTaskHourTFS() == null) {
                attendanceInfo.setWorkTaskHourTFS(new BigDecimal(0));
            }
            if (attendanceInfo.getCalculationAttendanceHour() == null) {
                attendanceInfo.setCalculationAttendanceHour(new BigDecimal(0));
            }
            attendanceInfo.setDifferenceTFSAndCalculationHour(attendanceInfo.getWorkTaskHourTFS().subtract(attendanceInfo.getCalculationAttendanceHour()));
            attendanceInfoList.add(attendanceInfo);
        }


        int count = 1;
        List<AttendanceInfo> attendanceInfoListTemp = new ArrayList<>(1000);
        for (AttendanceInfo attendanceInfo : attendanceInfoList) {
            count++;
            attendanceInfoListTemp.add(attendanceInfo);
            if (count % 1000 == 0) {
                result += attendanceInfoDao.insertBatchAttendanceInfo(attendanceInfoListTemp);
                attendanceInfoListTemp = new ArrayList<>(1000);
            }
        }
        result += attendanceInfoDao.insertBatchAttendanceInfo(attendanceInfoListTemp);
        return result;
    }

    /**
     * 根据全量考勤筛选正确或错误考勤信息
     *
     * @param
     * @return
     * @author dongzhibo
     * @date 2023/3/21 10:59
     */
    public List<AttendanceInfo> getAttendanceInfoByRule(List<AttendanceInfo> attendanceInfoList, boolean flag) {

        List<AttendanceInfo> attendanceInfoErrorList = new ArrayList<AttendanceInfo>();
        List<AttendanceInfo> attendanceInfoTrueList = new ArrayList<AttendanceInfo>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = (Date) simpleDateFormat.parse("2023-03-10");
        } catch (Exception e) {
        }
        for (AttendanceInfo attendanceInfo : attendanceInfoList) {
            String mantissa = String.valueOf(attendanceInfo.getWorkTaskHourTFS()).split("\\.")[1];
            String list = "00_10_20_30_40_50_60_70_80_90";
            if (startDate != null && attendanceInfo.getAttendanceDate().getTime() >= startDate.getTime()
                    && list.indexOf(mantissa) < 0) {
                attendanceInfoErrorList.add(attendanceInfo);
            } else {
                if (attendanceInfo.getWorkTaskHourTFS() != null && attendanceInfo.getWorkTaskHour() != null
                        && attendanceInfo.getWorkTaskHourTFS().compareTo(attendanceInfo.getWorkTaskHour()) <= 0) {
                    if (attendanceInfo.getWorkTaskHour().compareTo(attendanceInfo.getCalculationAttendanceHour()) == 0) {
                        if (attendanceInfo.getWorkTaskHourTFS().compareTo(attendanceInfo.getCalculationAttendanceHour()) <= 0
                                && attendanceInfo.getWorkTaskHourTFS().compareTo(attendanceInfo.getCalculationAttendanceHour().subtract(new BigDecimal("0.1"))) == 1) {
                            attendanceInfoTrueList.add(attendanceInfo);
                        } else {
                            attendanceInfoErrorList.add(attendanceInfo);
                        }
                    }else {
                        if (attendanceInfo.getWorkTaskHourTFS().compareTo(attendanceInfo.getCalculationAttendanceHour()) >= 0
                                && attendanceInfo.getWorkTaskHourTFS().compareTo(attendanceInfo.getCalculationAttendanceHour().add(new BigDecimal("0.1"))) == -1) {
                            attendanceInfoTrueList.add(attendanceInfo);
                        }else {
                            attendanceInfoErrorList.add(attendanceInfo);
                        }
                    }
                } else if (CommonUtil.equals(attendanceInfo.getAttendanceState(), "请假")
                        && CommonUtil.equals(attendanceInfo.getCalculationAttendanceHour(), new BigDecimal("0"))
                        && CommonUtil.equals(attendanceInfo.getWorkTaskHourTFS(), new BigDecimal("0"))) {
                    attendanceInfoTrueList.add(attendanceInfo);
                } else if (CommonUtil.equals(attendanceInfo.getAttendanceState(), "远程办公")
                        && attendanceInfo.getWorkTaskHourTFS().compareTo(new BigDecimal("8")) >= 0) {
                    attendanceInfoTrueList.add(attendanceInfo);
                } else {
                    attendanceInfoErrorList.add(attendanceInfo);
                }
            }

        }
        if (flag) {
            return attendanceInfoTrueList;
        }
        return attendanceInfoErrorList;
    }


}
