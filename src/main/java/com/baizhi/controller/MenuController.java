package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.entity.TreeNode;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService service;

    @RequestMapping("/getCategoryTree")
    public List<TreeNode> getCategoryTree(){
        return service.getCategoryTree();
    }

    @RequestMapping("/getMenus")
    public List<Menu> getMenus(){
        return service.getMenus();
    }
}
