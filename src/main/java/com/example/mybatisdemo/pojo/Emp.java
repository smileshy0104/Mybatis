package com.example.mybatisdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 员工实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    /*
    - 实体类属性名和数据库表查询返回的字段名一致，mybatis会自动封装。
    - 如果实体类属性名和数据库表查询返回的字段名不一致，不能自动封装。
     */
    private LocalDate entrydate;     //LocalDate类型对应数据表中的date类型
    private Integer deptId;
    private LocalDateTime createTime;//LocalDateTime类型对应数据表中的datetime类型
    private LocalDateTime updateTime;
}
