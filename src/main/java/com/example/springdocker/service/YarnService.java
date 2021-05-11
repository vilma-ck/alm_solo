package com.example.springdocker.service;

import com.example.springdocker.model.Yarn;
import com.example.springdocker.repository.YarnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-11
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@RequiredArgsConstructor
@Service
public class YarnService {
    private final YarnRepository repository;

    public List<Yarn> getYarns(){
        return repository.findAll();
    }

    public void saveNewYarn(Yarn yarn){
        repository.save(yarn);
    }

    public List<String> getWoolYarns(){
        // hämtar alla garner av ull
        List<Yarn> woolenYarns = repository.findYarnByWool(true);

        // returnerar garnernas namn
        return woolenYarns.stream().map(yarn -> yarn.getName()).collect(Collectors.toList());
    }


}
