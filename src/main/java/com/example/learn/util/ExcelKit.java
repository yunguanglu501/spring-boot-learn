package com.example.learn.util;

/**
 * @Author: wcy
 * @Date: 2022/7/8 14:21
 * @Version 1.0
 */


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;

import java.util.*;

/**
 * ExcelKit excel文件处理库，依赖Hutool
 */
public class ExcelKit {


    public static void main(String[] args) {
        List<Map<String, Object>> maps = readBigExcel("D:\\禅医账户绑定就诊卡信息.xlsx", -1);
        int sum = 0;
        for (int i = 0; i < maps.size(); i++) {
            sum++;
            System.out.println("i = " + maps.get(i));
        }
        System.out.println("sum = " + sum);
    }

    private static List<Object> headLine;
    private static List<Map<String, Object>> datas = new ArrayList<>();

    /**
     * @param pathAndName        文件路径
     * @param idOrRidOrSheetName Excel中的sheet id或者rid编号或sheet名称，rid必须加rId前缀，例如rId1，如果为-1处理所有编号的sheet
     */
    public static List<Map<String, Object>> readBigExcel(String pathAndName, int idOrRidOrSheetName) {
        Console.log("【{}】 开始读取 ... ", pathAndName);
        datas.clear();
        Excel07SaxReader reader = new Excel07SaxReader(new MyRowHandler());
        reader.read(pathAndName, idOrRidOrSheetName);
        Console.log("【{}】 读取完成 ... ", pathAndName);
        return datas;
    }

    /**
     * @param pathAndName        文件路径
     * @param idOrRidOrSheetName Excel中的sheet id或者rid编号或sheet名称，rid必须加rId前缀，例如rId1，如果为-1处理所有编号的sheet
     * @param beanType           类类型
     * @param <T>                返回值为List<T>
     * @return
     */
    public static <T> List<T> read(String pathAndName, int idOrRidOrSheetName, Class<T> beanType) {
        return read(pathAndName, idOrRidOrSheetName, beanType, Collections.EMPTY_MAP);
    }

    /**
     * @param pathAndName        文件路径
     * @param idOrRidOrSheetName Excel中的sheet id或者rid编号或sheet名称，rid必须加rId前缀，例如rId1，如果为-1处理所有编号的sheet
     * @param beanType           类类型
     * @param fieldMapping       T类型对应的别名，即类类型对应的 excel 的关系
     * @param <T>                返回值为List<T>
     * @return
     */
    public static <T> List<T> read(String pathAndName, int idOrRidOrSheetName, Class<T> beanType, Map<String, String> fieldMapping) {
        CopyOptions copyOptions = CopyOptions.create();
        if (CollUtil.isNotEmpty(fieldMapping)) {
            copyOptions.setFieldMapping(fieldMapping);
        }
        readBigExcel(pathAndName, idOrRidOrSheetName);
        List<T> datalist = new ArrayList<>();
        for (Map<String, Object> data : datas) {
            T t = ReflectUtil.newInstanceIfPossible(beanType);
            datalist.add(BeanUtil.fillBeanWithMap(data, t, copyOptions));
        }
        return datalist;
    }

    private static class MyRowHandler implements RowHandler {
        @Override
        public void handle(int sheetIndex, long rowIndex, List<Object> rowList) {
            //Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowList);
            if (rowIndex == 0) {
                headLine = rowList;
            } else {
                Map<String, Object> tMap = new HashMap<>(rowList.size());
                for (int i = 0; i < rowList.size(); i++) {
                    tMap.put(transStr(headLine.get(i)), rowList.get(i));
                }
                datas.add(tMap);
            }
        }
    }

    private static String transStr(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}
