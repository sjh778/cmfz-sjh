package com.baizhi.dao;

import com.baizhi.entity.Menu;
import com.baizhi.entity.TreeNode;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface MenuDao {
    public List<TreeNode> getCategoryTree();

    public List<Menu> getMenus();
}
