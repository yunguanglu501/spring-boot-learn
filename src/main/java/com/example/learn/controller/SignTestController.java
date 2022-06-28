package com.example.learn.controller;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 17:41
 */

import com.example.learn.anno.Signature;
import com.example.learn.common.Result;
import com.example.learn.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pdai
 */
@RestController
@RequestMapping("user")
public class SignTestController {

    @Signature
    @PostMapping("test/{id}")
    public Result<String> myController(@PathVariable String id
            , @RequestParam String client
            , @RequestBody User user) {
        return Result.of(String.join(",", id, client, user.toString()));
    }

}

