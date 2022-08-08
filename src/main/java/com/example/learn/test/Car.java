package com.example.learn.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private int id;
    private String type;
    private double price;
    private char level;

    public static void main(String[] args) {
        System.out.println("\"202202281604553950\".length() = " + "202202281604553950".length());
    }
}
