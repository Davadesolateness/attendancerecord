package com.example.attendance.service;

import com.example.attendance.dao.AttendanceInfoDao;
import com.example.attendance.entity.AttendanceInfo;
import com.example.attendance.vo.AttendanceInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
            if (count % 1000 == 0){
                result += attendanceInfoDao.insertBatchAttendanceInfo(attendanceInfoListTemp);
                attendanceInfoListTemp = new ArrayList<>(1000);
            }
        }
        result += attendanceInfoDao.insertBatchAttendanceInfo(attendanceInfoListTemp);
        return result;
    }

}
