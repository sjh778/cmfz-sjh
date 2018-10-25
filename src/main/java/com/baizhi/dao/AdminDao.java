package com.baizhi.dao;

import com.baizhi.entity.Admin;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface AdminDao {
    public Admin queryByUsername(String username);
}
