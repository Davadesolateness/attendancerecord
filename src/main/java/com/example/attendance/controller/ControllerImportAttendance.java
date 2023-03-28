package com.example.attendance.controller;

import com.example.attendance.dao.PersonInfoDao;
import com.example.attendance.entity.AttendanceInfo;
import com.example.attendance.service.AttendanceInfoService;
import com.example.attendance.service.ExportExcelDataService;
import com.example.attendance.service.ImportExcelDataService;
import com.example.attendance.service.PersonInfoService;
import com.example.attendance.vo.AttendanceInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author dongzhibo
 * @version 1.0
 * @description: 此控制层，进行页面上进行导入考勤的相关操作
 * @date 2023/3/16 16:33
 */
@Controller
@RequestMapping("/importAttendance")
public class ControllerImportAttendance {

    @Autowired
    private ImportExcelDataService importExcelDataService;

    @Autowired
    private AttendanceInfoService attendanceInfoService;

    @Autowired
    private PersonInfoService personInfoService;

    @Autowired
    private ExportExcelDataService exportExcelDataService;

    @RequestMapping("/importRawData")
    public void importAttendAnce() {
        File file = new File("E:\\bbb.xls");
        MultipartFile multipartFile = importExcelDataService.getMultipartFile(file);
        List<AttendanceInfoVo> attendanceInfoVoList = importExcelDataService.importAttendanceData(multipartFile, AttendanceInfoVo.class);
        int result = attendanceInfoService.savaAttendanceInfo(attendanceInfoVoList);
        System.out.println(result);
    }

    @RequestMapping("/getAttendance")
    public void getAttendanceByUserCode(@RequestParam(value = "userCode") String userCode,@RequestParam(value = "flag") boolean flag, HttpServletResponse response) {
        List<AttendanceInfo> attendanceInfoList = attendanceInfoService.getAttendanceInfo(userCode, flag);
        exportExcelDataService.exportExcelData(response, "用户表", attendanceInfoList);
        System.out.println("111111111111");
    }

    public ImportExcelDataService getImportExcelDataService() {
        return importExcelDataService;
    }

    public void setImportExcelDataService(ImportExcelDataService importExcelDataService) {
        this.importExcelDataService = importExcelDataService;
    }

    public AttendanceInfoService getAttendanceInfoService() {
        return attendanceInfoService;
    }

    public void setAttendanceInfoService(AttendanceInfoService attendanceInfoService) {
        this.attendanceInfoService = attendanceInfoService;
    }

    public PersonInfoService getPersonInfoService() {
        return personInfoService;
    }

    public void setPersonInfoService(PersonInfoService personInfoService) {
        this.personInfoService = personInfoService;
    }
}
