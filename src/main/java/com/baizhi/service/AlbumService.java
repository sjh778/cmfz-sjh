package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public interface AlbumService {
    public List<Album> getAlbumTree();

    public void add(Album album);
}
