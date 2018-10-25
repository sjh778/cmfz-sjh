package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService service;

    @RequestMapping("/getAllBanner")
    public Map getAllBanner(int page,int rows){
        return service.getAllBanner(page,rows);
    }

    @RequestMapping("/update")
    public boolean update(Banner ban){
        try {
            service.update(ban);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @RequestMapping("/delete")
    public void delete(int id){
        service.delete(id);
    }
    @RequestMapping("/add")
    public boolean add(Banner banner,MultipartFile multipartFile,HttpServletRequest req){
        try {
            String realpath = req.getRealPath("/img");
            System.out.println(realpath);
            String oldFileName = multipartFile.getOriginalFilename();
            System.out.println(oldFileName);
            String filename = new Date().getTime()+"_"+oldFileName;
            File file = new File(realpath+"/"+filename);
            try {
                multipartFile.transferTo(file);
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String url = "/img/"+filename;
            banner.setUrl(url);
            service.add(banner);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
