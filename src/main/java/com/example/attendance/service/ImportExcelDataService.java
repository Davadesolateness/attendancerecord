package com.example.attendance.service;

import com.example.attendance.util.ExcelUtils;
import com.example.attendance.vo.AttendanceInfoVo;
import org.apache.http.entity.ContentType;
import org.apache.poi.util.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @description: TODO
 * @author dongzhibo
 * @date 2023/3/17 18:01
 * @version 1.0
 */
@Service
public class ImportExcelDataService {

    public List<AttendanceInfoVo> importAttendanceData(MultipartFile file,Class clazz){
        List<AttendanceInfoVo> attendanceInfoVoList = null;
        try {
            attendanceInfoVoList = ExcelUtils.readMultipartFile(file,clazz);
            System.out.println("aaa");
        } catch (Exception e) {
            System.out.println("解析失败");
            e.printStackTrace();
        }
        return attendanceInfoVoList;
    }

    public MultipartFile getMultipartFile(File file){
        FileInputStream fileInputStream = null;
        MultipartFile multipartFile = null;
        try {
            fileInputStream = new FileInputStream(file);
            multipartFile = new MockMultipartFile(file.getName(),file.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multipartFile;
    }
}
