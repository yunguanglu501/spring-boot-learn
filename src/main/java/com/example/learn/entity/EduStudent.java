package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
  * @Description:    
  * @Author:         wcy
  * @CreateDate:     2022/6/8 17:17
 */

/**
 * 学生表
 */
@Data
@TableName(value = "edu_student")
public class EduStudent {
    /**
     * 学号
     */
    @TableId(value = "stu_id", type = IdType.AUTO)
    private String stuId;

    /**
     * 学生姓名
     */
    @TableField(value = "stu_name")
    private String stuName;
}