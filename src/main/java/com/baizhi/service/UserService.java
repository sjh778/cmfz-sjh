package com.baizhi.service;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/28 0028.
 */
public interface UserService {
    public Map selectAll(int page, int rows);

    public List<User> selectAllUser();

    public List<Integer> getCountByDate();

    public Map getdistribution();


}





