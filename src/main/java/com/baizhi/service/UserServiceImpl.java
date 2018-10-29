package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/28 0028.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao dao;
    @Override
    public Map selectAll(int page, int rows) {
        Map map = new HashMap();
        int start = (page -1)*rows;
        int end = page * rows;
        List<User> users = dao.selectAll(start, end);
        int count = dao.getCount();
        map.put("rows",users);
        map.put("total",count);
        return map;
    }

    @Override
    public List<User> selectAllUser() {
        return dao.selectAllUser();
    }

    @Override
    public List<Integer> getCountByDate() {
        Map map = new HashMap();
        Integer i = dao.selectCountByDate1();
        Integer i1 = dao.selectCountByDate2();
        Integer i2 = dao.selectCountByDate3();
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(i1);
        list.add(i2);
        return list;
    }

    @Override
    public Map getdistribution() {
        Map map = new HashMap();
        List<UserDTO> userDTOS = dao.selectCountByProvince1();
        List<UserDTO> userDTOS1 = dao.selectCountByProvince2();
        map.put("a",userDTOS);
        map.put("b",userDTOS1);
        System.out.println(map.get("a"));
        return map;


    }
}
