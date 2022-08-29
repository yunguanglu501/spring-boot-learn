package com.example.learn.test;

import cn.hutool.core.date.DateUtil;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;

/**
 * Demo003
 *
 * @author wcy
 * @date 2022/8/29
 */
public class Demo003 {
    public static void main(String[] args) {
        // 格式一
        String date1 = "2022-08-29 10:06:19";
        // String date2 = "2019-02-12";
        String date2 = DateUtil.now();
        System.out.println("date2 = " + date2);
        // 格式二
        // String date1 = "20190121";
        // String date2 = "20190212";
        int compareTo = date1.compareTo(date2);
        if (compareTo > 0) {
            System.out.println("date1 大于 date2");
        } else if (compareTo == 0) {
            System.out.println("date1 等于 date2");
        } else if (compareTo < 0) {
            System.out.println("date1 小于 date2");
        }

    }
}
