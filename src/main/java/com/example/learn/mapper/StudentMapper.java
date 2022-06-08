package com.example.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learn.entity.Student;

import java.util.List;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 17:59
 */
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> listStudents();
}