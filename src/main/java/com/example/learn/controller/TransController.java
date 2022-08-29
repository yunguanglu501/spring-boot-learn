package com.example.learn.controller;

import com.example.learn.fx.FxPerson;
import com.example.learn.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TransController
 *
 * @author wcy
 * @date 2022/8/29
 */
@RestController
public class TransController {

    @Autowired
    TransService transService;

    @RequestMapping("testTrans")
    public String testTrans(Integer num) {
        transService.testTrans(num);
        return "success";
    }
}
