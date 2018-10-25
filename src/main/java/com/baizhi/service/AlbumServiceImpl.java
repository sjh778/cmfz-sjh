package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
    @Autowired
    private AlbumDao dao;
    @Override
    public List<Album> getAlbumTree() {
        return dao.getAlbumTree();
    }

    @Override
    public void add(Album album) {
        dao.insert(album);
    }
}
