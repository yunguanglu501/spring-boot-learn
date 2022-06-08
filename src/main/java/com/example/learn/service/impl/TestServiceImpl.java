package com.example.learn.service.impl;

import com.example.learn.entity.Item;
import com.example.learn.entity.Result;
import com.example.learn.service.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 9:54
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public Result<Item> getItem() {
        Item item = new Item();
        item.setName("张三");
        item.setValue("13");

        Result<Item> itemResult = new Result<>();
        itemResult.setData(item);
        itemResult.setRet(0);
        itemResult.setMsg("Success");
        return itemResult;
    }

    @Override
    public Result<List<Item>> getItems() {
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setName("张三");
        item.setValue("13");

        Item item2 = new Item();
        item2.setName("李四");
        item2.setValue("14");

        items.add(item2);
        items.add(item);
        Result<List<Item>> itemResult = new Result<>();
        itemResult.setData(items);
        itemResult.setRet(0);
        itemResult.setMsg("Success");
        return itemResult;
    }
}
