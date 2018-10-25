package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public class Album {
    private int id;
    private String name;
    private String coverImg;
    private String aucthor;
    private String broadCast;
    private int count;
    private String brief;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private int score;
    private List<Chapter> children;

    public Album() {
    }

    public Album(int id, String name, String coverImg, String aucthor, String broadCast, int count, String brief, Date publishDate, int score, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.coverImg = coverImg;
        this.aucthor = aucthor;
        this.broadCast = broadCast;
        this.count = count;
        this.brief = brief;
        this.publishDate = publishDate;
        this.score = score;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getAucthor() {
        return aucthor;
    }

    public void setAucthor(String aucthor) {
        this.aucthor = aucthor;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", aucthor='" + aucthor + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", count=" + count +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", score=" + score +
                ", children=" + children +
                '}';
    }
}
