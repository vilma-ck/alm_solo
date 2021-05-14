package com.example.springdocker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-14
 * Project: spring-docker-demo
 * Copyright: MIT
 */
class MyMathCalcTest {

   MyMathCalc mmc;

   @BeforeEach
   public void init(){
      mmc = new MyMathCalc();
   }

    @Test
    void add() {
       assertEquals(10, mmc.add(5,5));
       assertEquals(4, mmc.add(2,2));
    }

    @Test
    void multiply() {
      assertEquals(20, mmc.multiply(2,10));
      assertEquals(16, mmc.multiply(4,4));
    }

    @Test
    void divide() {
      assertEquals(10, mmc.divide(20,2));
      assertEquals(3, mmc.divide(24,8));
    }

    @Test
   public void divide_error(){
      assertThrows(ArithmeticException.class, () -> mmc.divide(20,0));
    }
}