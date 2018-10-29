package com.baizhi.entity;

/**
 * Created by Administrator on 2018/10/29 0029.
 */
public class UserDTO {
    private Integer value;
    private String name;

    public UserDTO() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
