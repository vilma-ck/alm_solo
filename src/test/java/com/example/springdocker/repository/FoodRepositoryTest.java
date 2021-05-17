package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-14
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@DataMongoTest
class FoodRepositoryTest {

    // får använda @Autowired eftersom vi låter spring boot köra testet
    // motsvarar @BeforeEach när man inte kör med spring boot
    @Autowired
    FoodRepository foodRepository;


    @Test
    void findFoodByCanICookIt_true() {
        Food food = new Food("001", "Grönkål", true, true);
        List<Food> expected = Arrays.asList(food);

        foodRepository.save(food);

        assertEquals(expected, foodRepository.findFoodByCanICookIt(true));
    }

    @Test
    void findFoodByCanICookIt_false() {
        Food food = new Food("002", "Entrecote", false, false);
        List<Food> expected = Arrays.asList(food);

        foodRepository.save(food);

        assertEquals(expected, foodRepository.findFoodByCanICookIt(false));
    }
}