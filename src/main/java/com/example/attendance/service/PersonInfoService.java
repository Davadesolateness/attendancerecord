package com.example.attendance.service;

import com.example.attendance.dao.AttendanceInfoDao;
import com.example.attendance.dao.PersonInfoDao;
import com.example.attendance.entity.AttendanceInfo;
import com.example.attendance.entity.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: TODO
 * @author dongzhibo
 * @date 2023/3/21 10:52
 * @version 1.0
 */
@Service
public class PersonInfoService {

    @Autowired
    private PersonInfoDao personInfoDao;

    @Autowired
    private AttendanceInfoDao attendanceInfoDao;

    /**
     * 根据人员代码获取人员信息数据
     * @param userCode  人员代码
     * @return
     * @author dongzhibo
     * @date 2023/3/21 10:59
     */
    public List<AttendanceInfo> getAttendanceInfo(String userCode){
        Set<String> userCodeSet = new HashSet<>();
        this.getGroupPersonByProjectCode(userCode,userCodeSet);
        List<AttendanceInfo> attendanceInfoList = attendanceInfoDao.queryAttendanceInfoListByUserCode(userCodeSet);
        return attendanceInfoList;
    }

    /**
     * 获取该人员组下的人员数据,以项目组维度进行获取
     * @param userCode
     * @return Set 组内人员代码集合
     */
    private void getGroupPersonByProjectCode(String userCode,Set userCodeSet){
        // 1. 获取直接属于该人员的所有人员数据
        List<PersonInfo> personInfoList = personInfoDao.queryPersonInfoListByProjectTeamLeaderCode(userCode);
        // 2 递归遍历组内所有人员，查询其下面是否还有人
        if (personInfoList != null && personInfoList.size() > 0){
            for (PersonInfo personInfo : personInfoList){
                this.getGroupPersonByProjectCode(personInfo.getUserCode(),userCodeSet);
            }
        }
        userCodeSet.add(userCode);
    }
}
