package com.example.attendance.dao;

import com.example.attendance.entity.AttendanceInfo;
import com.example.attendance.entity.PersonInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: TODO
 * @author dongzhibo
 * @date 2023/3/21 9:50
 * @version 1.0
 */
@Mapper
public interface PersonInfoDao {

    /**
     * 根据人员代码查询数据
     * @param userCode 人员代码
     * @return 
     * @author dongzhibo
     * @date 2023/3/21 10:46
     */
    List<PersonInfo> queryPersonInfoListByUserCode(String userCode);

    /**
     * 查询项目团队组长代码是入参的人员,在项目组人员维度
     * @param userCode 人员代码
     * @return
     * @author dongzhibo
     * @date 2023/3/21 11:14
     */
    List<PersonInfo> queryPersonInfoListByProjectTeamLeaderCode(String userCode);

    /**
     * 查询项目团队组长代码是入参的人员,在职能组人员维度
     * @param userCode 人员代码
     * @return
     * @author dongzhibo
     * @date 2023/3/21 11:14
     */
    List<PersonInfo> queryPersonInfoListByFunctionTeamLeaderCode(String userCode);
}
