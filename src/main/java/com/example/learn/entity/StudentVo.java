package com.example.learn.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/13 10:36
 */
@Data
public class StudentVo {
    /**
     * 学号
     */

    private String stuId;

    /**
     * 学生姓名
     */

    private String stuName;

    /**
     * 年龄
     */

    private Integer stuAge;


    private Integer isDel;

}
