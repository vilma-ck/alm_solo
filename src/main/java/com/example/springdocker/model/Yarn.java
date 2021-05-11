package com.example.springdocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-11
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yarn {
    String id;
    String name;
    boolean wool;
    boolean colour;
}
