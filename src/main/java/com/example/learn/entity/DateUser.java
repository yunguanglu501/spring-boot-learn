package com.example.learn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * DateUser
 *
 * @author wcy
 * @date 2022/8/3
 */
@Data
public class DateUser {
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //适用formdata类型接收
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

}
