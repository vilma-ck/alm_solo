package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-14
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    FoodService foodService;

    // "manuell" autowired
    @Mock
    FoodRepository mockRepository;

    @BeforeEach
    public void init(){
        foodService = new FoodService(mockRepository);
        // lombok @RequiredArgsConstructor
    }

    @Test
    void getFoods() {
        // set up
        Food food = new Food("001", "Grönkål", true, true);

        when(mockRepository.findAll()).thenReturn(Arrays.asList(food));

        // metodanrop
        List<Food> actual = foodService.getFoods();

        // assertions tester
        assertEquals(food.getName(), actual.get(0).getName());
        assertEquals(food.getId(), actual.get(0).getId());
        assertEquals(1, actual.size());

        verify(mockRepository).findAll();

    }

    @Disabled
    @Test
    void saveNewFood_success() {
        Food foodMock = new Food("001", "Grönkål", true, true);
        mockRepository.save(foodMock);
        Food foodTest = new Food("002", "Entrecote", false, false);

        // metodanrop
        boolean success = foodService.saveNewFood(foodTest);

        assertEquals(true, success);
        verify(mockRepository, times(2)).save(any());
        verify(mockRepository).findFoodById(anyString());
    }

    @Disabled
    @Test
    void saveNewFood_fail() {
        Food foodMock = new Food("001", "Grönkål", true, true);
        mockRepository.save(foodMock);
        Food foodTest = new Food("001", "Grönkål", true, true);

        when(mockRepository.save(foodTest)).thenReturn(foodTest);
        // metodanrop
        boolean success = foodService.saveNewFood(foodTest);

        System.out.println(mockRepository.save(foodTest));
        System.out.println(foodService.getFoods());
        System.out.println(success);
/**
        assertEquals(false, success);
        verify(mockRepository, times(1)).save(any());
        verify(mockRepository).findFoodById(anyString());
 **/
    }

    @Test
    void getCookableFoods() {
    }
}