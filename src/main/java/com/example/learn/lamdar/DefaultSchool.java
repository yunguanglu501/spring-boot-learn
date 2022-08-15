package com.example.learn.lamdar;

/**
 * DefaultSchool
 *
 * @author wcy
 * @date 2022/8/10
 */
public class DefaultSchool implements StudyWarp.GOSchool{
    @Override
    public boolean hasCar() {
        return true;
    }
}
