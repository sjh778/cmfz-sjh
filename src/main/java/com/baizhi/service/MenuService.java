package com.baizhi.service;

import com.baizhi.entity.Menu;
import com.baizhi.entity.TreeNode;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface MenuService {
    public List<TreeNode> getCategoryTree();

    public List<Menu> getMenus();
}
