package com.example.learn.entity;

import java.io.*;

/**
 * SerializableTest
 *
 * @author wcy
 * @date 2022/8/25
 */
public class SerializableTest {

    private static void serialize(SeriUser user) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\111.txt")));
        oos.writeObject(user);
        oos.close();
    }

    private static SeriUser deserialize() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\111.txt")));
        return (SeriUser) ois.readObject();
    }

    public static void main(String[] args) throws Exception{
        SeriUser user = new SeriUser();
        user.setName("tyshawn");
        user.setAge(18);
        System.out.println("序列化前的结果: " + user);

        // serialize(user);

        SeriUser dUser = deserialize();
        System.out.println("反序列化后的结果: " + dUser);
    }

}
