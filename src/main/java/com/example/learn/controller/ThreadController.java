package com.example.learn.controller;

import com.example.learn.common.Result;
import com.example.learn.service.StudentService;
import com.example.learn.util.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/7/1 9:22
 */
@RestController
@Slf4j
public class ThreadController {

    @Autowired
    StudentService studentService;

    @GetMapping("tokentest")
    public Result<String> tokentest(){
        System.out.println("controller:" + ThreadLocalUtils.getToken());
        String tableName = studentService.saveUser();
        return Result.of(tableName);
    }

}
