package com.example.learn.lamdar;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo010
 *
 * @author wcy
 * @date 2022/8/9
 */
public class Demo010 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap() {{
            put("map1", "value1");
            put("map2", "value2");
            put("map3", "value3");
        }};
        map.forEach((k, v) -> {
            System.out.println("key:" + k + " value:" + v);
        });
    }
}
