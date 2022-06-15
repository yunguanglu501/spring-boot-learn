package com.example.learn.service;

import com.example.learn.common.Result;
import com.example.learn.entity.Student;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 19:58
 */
public interface StudentService {
    Result<Student> selectOne(String name);

}
