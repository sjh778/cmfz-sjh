package com.baizhi.service;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Service("userService")
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao dao;

    @Override
    public Map login(String username, String password) {
        Map map = new HashMap();
        Admin admin = dao.queryByUsername(username);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                map.put("isLogin",true);
                map.put("admin",admin);
            }else{
                map.put("isLogin",false);
            }
        }else{
            map.put("isLogin",false);
        }
        return map;
    }
}
