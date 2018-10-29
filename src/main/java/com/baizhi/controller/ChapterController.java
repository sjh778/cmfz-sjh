package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;


import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
            //获取audio目录的绝对路径
            String realpath = req.getSession().getServletContext().getRealPath("/audio");
            System.out.println(realpath);
            //获取文件的原始文件名
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
            //获取上传音频文件的时长
            Encoder encoder = new Encoder();
            MultimediaInfo multimediaInfo = encoder.getInfo(file);
            Long time = multimediaInfo.getDuration() / 1000;

            String url = "audio/"+filename;
            Album album = new Album();
            album.setId(aid);
            cha.setAlbum(album);
            cha.setDuration(time/60+""+":"+time%60+"");
            //获取上传文件的大小并赋值给对象的size属性
            cha.setSize(multipartFile.getSize()/1024+""+"KB");
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
    public void download(String name,String filename, HttpServletRequest req, HttpServletResponse response) throws UnsupportedEncodingException {
        //获取项目根路径
        String realpath = req.getSession().getServletContext().getRealPath("/");
        System.out.println(realpath+filename);
        //System.out.println(filename);
        File file = new File(realpath+filename);
        //获取文件后缀
        String s = FilenameUtils.getExtension(filename);
        //将章节name拼接后缀得到下载的文件名
        String newFileName = name+"."+s;
        response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(newFileName,"UTF-8"));
        response.setContentType("audio/mpeg");
        try {
            FileUtils.copyFile(file,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
