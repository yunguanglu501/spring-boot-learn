package com.example.learn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.example.learn.entity.Item;
import com.example.learn.entity.Result;
import com.example.learn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 9:53
 */
@RestController
public class TestController {


    @Autowired
    TestService testService;


    @RequestMapping("test2")
    public List<Item> getItems() {
        Result<List<Item>> itemResult = testService.getItems();
        String jsonString = JSON.toJSONString(itemResult);
        System.out.println("jsonString = " + jsonString);
//        demo04(jsonString);

        Result<List<Item>> listResult = parseListResult2(jsonString, Item.class);
        System.out.println("listResult = " + listResult);
        System.out.println(listResult.getData());
        return listResult.getData();
    }

    private void demo04(String jsonString) {
        Result listResult = parseResultV2(jsonString, List.class);
        System.out.println("listResult = " + listResult);
        Object data = listResult.getData();
        Class<?> aClass = data.getClass();
        System.out.println("aClass = " + aClass);
        System.out.println("data = " + data);
        List<Item> lists = (List<Item>) data;
    }

    @RequestMapping("test")
    public Item getItem() {
        Result<Item> itemResult = testService.getItem();
        String jsonString = JSON.toJSONString(itemResult);
        System.out.println("jsonString = " + jsonString);
//        demo01(jsonString);

//        demo03(jsonString);
//        demo02(jsonString);
        Result<Item> itemResult1 = parseResultV2(jsonString, Item.class);
        System.out.println("itemResult1 = " + itemResult1);
        System.out.println(itemResult1.getData());
        return itemResult1.getData();
    }

    private void demo02(String jsonString) {
        //可行的
        Result<Item> result = JSONObject.parseObject(jsonString, new TypeReference<Result<Item>>() {
        });

        System.out.println("result = " + result);
        Item data = result.getData();
        System.out.println("data = " + data);
    }

    private void demo03(String jsonString) {
        //不可行
        Result<Item> objectResult = parseResultV1(jsonString);
        System.out.println("objectResult = " + objectResult);
//        JSONObject aClass = objectResult.getData();
//        System.out.println("aClass = " + aClass);
        //该步骤会报错.
        Item data = objectResult.getData();
        System.out.println("data = " + data);
    }



    private void demo01(String jsonString) {
        Result result = JSONObject.parseObject(jsonString, Result.class);
        System.out.println("result = " + result);
        Object data = result.getData();
        System.out.println("data = " + data);
    }


    private static <T> Result<T> parseResultV1(String json) {
        //该方法不知道t的类型,调用时也没传过来
        return JSONObject.parseObject(json, new TypeReference<Result<T>>() {

        });
    }

    //解决T不是List<T>类型的
    private static <T> Result<T> parseResultV2(String json, Class<T> clazz) {

        //后来发现parseResultV2无法处理类似`Result<List<T>>`，原来TypeReference无法处理嵌套的泛型（这里指的是类型参数未确定，
        // 而不是类似`Result<List<Item>>`类型参数已经确定）。
        // 借用[Fastjson解析多级泛型的几种方式—使用class文件来解析多级泛型](https://www.cnblogs.com/itar/p/7427971.html)里的方法，
        // 新增加一个专门处理List类型的方法：
        return JSONObject.parseObject(json, new TypeReference<Result<T>>(clazz) {
        });
    }

    //解决list<T>
    private static <T> Result<List<T>> parseListResult(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, buildType(Result.class, List.class, clazz));
    }

    private static Type buildType(Type... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types != null && types.length > 0) {
            for (int i = types.length - 1; i > 0; i--) {
                beforeType = new ParameterizedTypeImpl(new Type[]{beforeType == null ? types[i] : beforeType}, null, types[i - 1]);
            }
        }
        return beforeType;
    }


    private static <T> Result<List<T>> parseListResult2(String json, Class<T> clazz) {
        ParameterizedTypeImpl inner = new ParameterizedTypeImpl(new Type[]{clazz}, null, List.class);
        ParameterizedTypeImpl outer = new ParameterizedTypeImpl(new Type[]{inner}, null, Result.class);
        return JSONObject.parseObject(json, outer);
    }
}
