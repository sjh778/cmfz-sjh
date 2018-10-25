package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface BannerDao {
    public List<Banner> getAllBanner(@Param("start")int Start,@Param("end")int end);
    public int getCount();
    public void update(Banner banner);

    public void delete(int id);

    public void insert(Banner banner);
}
