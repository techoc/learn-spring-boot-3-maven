package cn.techoc.learnmybatismysql.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String type;
    private Double price;
    private String description;
    private Integer stock;
    private Integer sales;
    private Integer version;
    private Integer isDeleted;
    private Integer createUser;
    private Integer updateUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String cover;
    private String ISBN;
}
