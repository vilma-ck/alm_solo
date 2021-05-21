package com.example.springdocker.service;

import com.example.springdocker.model.Food;
import com.example.springdocker.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository repository;

    public List<Food> getFoods() {
        return repository.findAll();
    }

    public void saveNewFood(Food food) {
        repository.save(food);
    }

    public Food saveNewFoodExt(Food food){
        boolean found = repository.findFoodByIdAndName(food.getId(), food.getName());
        if(found){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Food already exists.");
        }
        Food f = repository.save(food);
        //System.out.println(f);
        return f;
    }

    public List<String> getCookableFoods() {
        // hämtar alla Foods som vi kan laga
        List<Food> cookableFoods = repository.findFoodByCanICookIt(true);

        // returnerar endast Food namnen i en lista
        return cookableFoods.stream()
                .map(food -> food.getName())
                .collect(Collectors.toList());
    }

}
