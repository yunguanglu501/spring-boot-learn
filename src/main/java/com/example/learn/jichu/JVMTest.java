package com.example.learn.jichu;

/**
 * JVMTest
 *
 * @author wcy
 * @date 2022/8/16
 */
public class JVMTest {
    public static void main(String[] args) {
        SingleTon2.getInstance();
        System.out.println(SingleTon2.count1);
        System.out.println(SingleTon2.count2);
    }
}
