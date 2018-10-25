package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService service;

    @RequestMapping("/add")
    public boolean add(Chapter cha, int aid, MultipartFile multipartFile, HttpServletRequest req){
        try {
            String realpath = req.getSession().getServletContext().getRealPath("/audio");
            System.out.println(realpath);
            String oldFileName = multipartFile.getOriginalFilename();
            System.out.println(oldFileName);
            //获取文件名后缀
            //FilenameUtils.getExtension(oldFileName);
            String filename = new Date().getTime()+"_"+oldFileName;
            File file = new File(realpath+"/"+filename);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String url = "audio/"+filename;
            Album album = new Album();
            album.setId(aid);
            cha.setAlbum(album);
            cha.setUrl(url);
            cha.setId(UUID.randomUUID().toString());
            service.add(cha);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @RequestMapping("/download")
    public void download(String filename, HttpServletRequest req, HttpServletResponse response){
        String realpath = req.getSession().getServletContext().getRealPath("/");
        System.out.println(realpath+filename);
        //System.out.println(filename);
        File file = new File(realpath+filename);
        response.setHeader("content-disposition","attachment;filename="+filename);
        try {
            FileUtils.copyFile(file,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
