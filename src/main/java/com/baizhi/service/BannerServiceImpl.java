package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDao dao;

    @Override
    public Map getAllBanner(int page, int rows) {
        Map map = new HashMap();
        int start = (page -1) * rows;
        int end = page * rows;
        List<Banner> list = dao.getAllBanner(start,end);
        int count = dao.getCount();
        map.put("rows",list);
        map.put("total",count);
        return map;
    }

    @Override
    public void update(Banner banner) {
        dao.update(banner);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void add(Banner banner) {
        dao.insert(banner);
    }
}
