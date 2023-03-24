package com.example.attendance.dao;

import com.example.attendance.entity.AttendanceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * @description: TODO
 * @author dongzhibo
 * @date 2023/3/17 19:41
 * @version 1.0
 */
@Mapper
public interface AttendanceInfoDao {
    /**
     * 批量增加考勤数据
     * @param attendanceInfoList
     * @return int
     * @author dongzhibo
     * @date 2023/3/17 19:42
     */
    int insertBatchAttendanceInfo(List<AttendanceInfo> attendanceInfoList);

    /**
     * 保存单条数据
     * @param attendanceInfo
     * @return 
     * @author dongzhibo
     * @date 2023/3/17 21:22
     */
    int inserAttendanceInfo(AttendanceInfo attendanceInfo);

    /**
     * 通过人员代码批量查询考勤记录
     * @param stringSet 人员代码
     * @return List<AttendanceInfo>  考勤记录集合
     * @author dongzhibo
     * @date 2023/3/21 11:50
     */
    List<AttendanceInfo> queryAttendanceInfoListByUserCode(Set<String> stringSet);
}
