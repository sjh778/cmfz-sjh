package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import com.baizhi.entity.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao dao;
    @Override
    public List<TreeNode> getCategoryTree() {
        return dao.getCategoryTree();
    }

    @Override
    public List<Menu> getMenus() {
        return dao.getMenus();
    }
}
