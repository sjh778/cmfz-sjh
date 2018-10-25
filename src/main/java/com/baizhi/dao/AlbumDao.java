package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public interface AlbumDao {
    public List<Album> getAlbumTree();

    public void insert(Album album);
}
