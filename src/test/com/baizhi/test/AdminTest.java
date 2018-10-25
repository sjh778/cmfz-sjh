package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.AdminService;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=CmfzApp.class)
public class AdminTest {
    @Autowired
    AdminService service;
    @Autowired
    MenuService ms;
    @Autowired
    BannerService bs;
    @Autowired
    AlbumService as;
    @Test
    public void test(){
        System.out.println(service.login("zhangsan","qwer"));
    }
    @Test
    public void test2(){
        System.out.println(ms.getMenus());
    }
    @Test
    public void test3(){
        System.out.println(bs.getAllBanner(1,5));
    }
    @Test
    public void test4(){
        Banner ban = new Banner();
        ban.setId(6);
        //ban.setDesc("aaa");
        ban.setStatus("N");
        bs.update(ban);
    }
    @Test
    public void test5(){
        System.out.println(as.getAlbumTree());
    }

}
