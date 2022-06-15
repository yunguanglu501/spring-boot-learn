package com.example.learn.controller;

import com.example.learn.anno.ResponseResult;
import com.example.learn.common.Result;
import com.example.learn.entity.Student;
import com.example.learn.exception.BusinessException;
import com.example.learn.exception.ResultCode;
import com.example.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 14:01
 */
@ResponseResult
@RestController
@RequestMapping("/users")
public class StudentBaseController {

    @Autowired
    StudentService studentService;

    @RequestMapping("selectOneResult")
    public Student selectOneResult(@NotNull String name) {


        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
        return studentService.selectOneResult(name);

    }
}
