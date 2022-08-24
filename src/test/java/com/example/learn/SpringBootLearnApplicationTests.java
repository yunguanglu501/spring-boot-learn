package com.example.learn;

import com.example.learn.fx.Test01;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootLearnApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("k123","v124");
    }

    @Test
    void test01(){
        stringRedisTemplate.opsForValue().set("cloud-hospital"+ ":hospitalId" + 1 + ":departmentId" + 3,"11");
    }

}
