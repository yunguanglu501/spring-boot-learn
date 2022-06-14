package com.example.learn.entity;

import lombok.Data;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 14:38
 */
@Data
public class User {

    @NotNull(message = "用户ID不能为空")
    @NotBlank(message = "用户ID不能为空或空格")
    private String username;


    private String password;
}
