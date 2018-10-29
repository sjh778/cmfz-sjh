package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/28 0028.
 */
public class User {
    private Integer id;
    private String name;
    private String dharmaName;
    private String phoneNumber;
    private String password;
    private int gender;
    private String province;
    private String city;
    private String sign;
    private String headPic;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regDate;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", headPic='" + headPic + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
