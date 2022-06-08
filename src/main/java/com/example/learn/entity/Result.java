package com.example.learn.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 9:51
 */
@Data
public class Result<T> {
    private int ret;
    private String msg;
    private T data;
}
