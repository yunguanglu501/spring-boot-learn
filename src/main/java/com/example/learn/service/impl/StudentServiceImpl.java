package com.example.learn.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.learn.common.Result;
import com.example.learn.entity.Student;
import com.example.learn.mapper.StudentMapper;
import com.example.learn.service.StudentService;
import com.example.learn.util.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 19:58
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Result<Student> selectOne(String name) {
        return Result.of(studentMapper.selectOne(Wrappers.<Student>lambdaQuery().select(Student::getStuName, Student::getStuId).eq(Student::getStuName, name)));
    }

    @Override
    public Student selectOneResult(String name) {
        return studentMapper.selectOne(Wrappers.<Student>lambdaQuery().select(Student::getStuName, Student::getStuId).eq(Student::getStuName, name));
    }

    @Override
    public String saveUser() {
        String token = ThreadLocalUtils.getToken();
        //System.out.println("service:" + token);
        //return token;

        new Thread(() -> {
            String threadToken = ThreadLocalUtils.getToken();//获取不到
            System.out.println("new thread:" + threadToken);
        }).start();
        return token;
    }
}
