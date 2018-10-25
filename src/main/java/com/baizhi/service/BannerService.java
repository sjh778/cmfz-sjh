package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public interface BannerService {
    public Map getAllBanner(int page, int rows);
    public void update(Banner banner);
    public void delete(int id);

    public void add(Banner banner);
}
