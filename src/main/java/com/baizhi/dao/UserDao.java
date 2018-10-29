package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/28 0028.
 */
public interface UserDao {
    public List<User> selectAll(@Param("start")int start,@Param("end")int end);

    public int getCount();

    public List<User> selectAllUser();

    public int selectCountByDate1();
    public int selectCountByDate2();
    public int selectCountByDate3();

    public List<UserDTO> selectCountByProvince1();

    public List<UserDTO> selectCountByProvince2();
}
