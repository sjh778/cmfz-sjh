package com.baizhi.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public class Menu {
    private int id;
    private String title;
    private String iconCls;
    private String url;
    private List<Menu> menus;

    public Menu() {
    }

    public Menu(int id, String title, String iconCls, String url) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", menus=" + menus +
                '}';
    }
}
