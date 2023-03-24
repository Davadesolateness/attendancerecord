package com.example.attendance.service;

import com.example.attendance.entity.AttendanceInfo;
import com.example.attendance.util.ExcelUtils;
import com.example.attendance.vo.AttendanceInfoExportVo;
import com.example.attendance.vo.AttendanceInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongzhibo
 * @version 1.0
 * @description: TODO
 * @date 2023/3/21 13:24
 */
@Service
public class ExportExcelDataService {

    @Autowired
    private PersonInfoService personInfoService;

    public void exportExcelData(HttpServletResponse response, String fileName, List<AttendanceInfo> attendanceInfoList) {
        List<AttendanceInfoExportVo> attendanceInfoExportVoList = new ArrayList<>();
        // 将数据复制到导出的模板vo中
        for (AttendanceInfo attendanceInfo : attendanceInfoList){
            AttendanceInfoExportVo attendanceInfoExportVo = new AttendanceInfoExportVo();
            BeanUtils.copyProperties(attendanceInfo, attendanceInfoExportVo);
            attendanceInfoExportVoList.add(attendanceInfoExportVo);
        }
        ExcelUtils.export(response, "表", attendanceInfoExportVoList, AttendanceInfoExportVo.class);
    }
}
