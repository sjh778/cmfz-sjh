package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService service;

    @RequestMapping("/getAlbumTree")
    public List<Album> getAlbumTree(){
        return service.getAlbumTree();
    }

    @RequestMapping("/add")
    public boolean add(Album album, MultipartFile multipartFile, HttpServletRequest req){
        try {
            String realpath = req.getSession().getServletContext().getRealPath("/img");
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
            String url = "/img/"+filename;
            album.setCoverImg(url);
            service.add(album);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
