package com.baizhi.controller;


import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/28 0028.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    //展示
    @RequestMapping("/getAllUser")
    public Map getAllUser(int page, int rows){
        return service.selectAll(page,rows);
    }

    //自定义导出
    @RequestMapping("/customerExport")
    public void customerExport(HttpServletResponse response, String titles, String fileds){
        List<User> users = service.selectAllUser();
        String[] filedArray = fileds.split(",");
        String[] titleArray = titles.split(",");
        Workbook workbook = new HSSFWorkbook();

        CellStyle cellStyle1 = workbook.createCellStyle();
        //设置日期格式
        DataFormat dateFormat = workbook.createDataFormat();
        short format =dateFormat.getFormat("yyyy年mm月dd天");
        cellStyle1.setDataFormat(format);

        Sheet sheet = workbook.createSheet("user");
        Row row = sheet.createRow(0);
        for (int i = 0; i < titleArray.length; i++) {
            row.createCell(i).setCellValue(titleArray[i]);
        }

        for (int i = 0; i < users.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            Class<? extends User> aClass = users.get(i).getClass();
            for (int j = 0; j < filedArray.length; j++) {
                //getId
                String methodName = "get" + filedArray[j].substring(0, 1).toUpperCase() + filedArray[j].substring(1);
                try {
                    Object invoke = aClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                    if (invoke instanceof Date) {
                        Cell cell = row1.createCell(j);
                        cell.setCellStyle(cellStyle1);
                        cell.setCellValue((Date) invoke);
                        sheet.setColumnWidth(j, 22 * 256);
                    } else if (invoke instanceof Integer) {
                        Cell cell = row1.createCell(j);
                        cell.setCellValue((Integer) invoke);
                    } else {
                        Cell cell = row1.createCell(j);
                        cell.setCellValue(String.valueOf(invoke));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        long time = new Date().getTime();
        String s = time + "文件.xls";
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.ms-excel");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //全部导出
    @RequestMapping("/export")
    public void export(HttpServletResponse response,String opts){
        List<User> users = service.selectAllUser();
        String[] optArray = opts.split(",");
        List<String> titles = Arrays.asList("编号", "姓名","法名","注册日期");
        //构建标题栏
        Workbook workbook = new HSSFWorkbook();
        CellStyle cellStyle1 = workbook.createCellStyle();
        //设置日期格式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年mm月dd天");
        cellStyle1.setDataFormat(format);

        //创建单元格格式对象
        //居中
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置字体样式
        Font font = workbook.createFont();
        //加粗
        font.setBold(true);
        //红色
        font.setColor(Font.COLOR_RED);
        //字体类型
        font.setFontName("楷体");
        cellStyle.setFont(font);

        Sheet sheet = workbook.createSheet("user");
        //设置列宽
        sheet.setColumnWidth(2, 22 * 256);
        Row row = sheet.createRow(0);


        for (int i = 0; i < titles.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titles.get(i));
        }
        //构建数据行
        for (int i = 0; i < users.size(); i++) {
            Row row2 = sheet.createRow(i + 1);
            Class<? extends User> aClass = users.get(i).getClass();
            for (int j = 0; j <optArray.length ; j++) {
                //getId
                String methodName = "get" + optArray[j].substring(0, 1).toUpperCase() + optArray[j].substring(1);
                try {
                    Object invoke = aClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                    if (invoke instanceof Date) {
                        Cell cell = row2.createCell(j);
                        cell.setCellStyle(cellStyle1);
                        cell.setCellValue((Date) invoke);
                        sheet.setColumnWidth(j, 22 * 256);
                    } else if (invoke instanceof Integer) {
                        Cell cell = row2.createCell(j);
                        cell.setCellValue((Integer) invoke);
                    } else {
                        Cell cell = row2.createCell(j);
                        cell.setCellValue(String.valueOf(invoke));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        long time = new Date().getTime();
        String s = time + "文件.xls";
        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(s, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("application/vnd.ms-excel");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/importUser")
    public void importUser(MultipartFile excel) {
        Workbook workbook = null;
        try {
            InputStream inputStream = excel.getInputStream();
            workbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheet("user");
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            double id = row.getCell(0).getNumericCellValue();
            String name = row.getCell(1).getStringCellValue();
            String dharmaName = row.getCell(2).getStringCellValue();
            Date date = row.getCell(3).getDateCellValue();
            System.out.println("id" + id + "-----------" + "name" + name + "-----dharmaName"+dharmaName+"----------date" + date);

        }

    }
    @RequestMapping("/getRegStatistics")
    public List<Integer> getRegStatistics(){
        return service.getCountByDate();
    }

    @RequestMapping("/getDistribution")
    public Map getDistribution(){
        Map map = service.getdistribution();
        System.out.println(map);
        return map;
    }
}
