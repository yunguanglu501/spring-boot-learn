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
}
