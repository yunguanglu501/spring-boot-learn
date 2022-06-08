package com.example.learn.service;

import com.example.learn.entity.Item;
import com.example.learn.entity.Result;

import java.util.List;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 9:53
 */
public interface TestService {

    Result<Item> getItem();
    Result<List<Item>> getItems();
}
