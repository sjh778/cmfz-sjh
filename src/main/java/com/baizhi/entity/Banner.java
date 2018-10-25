package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public class Banner {
    private int id;
    private String title;
    private String url;
    private String desc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String status;

    public Banner() {
    }

    public Banner(int id, String title, String url, String desc, Date createDate, String status) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.desc = desc;
        this.createDate = createDate;
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                '}';
    }
}
