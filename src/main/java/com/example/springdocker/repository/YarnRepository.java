package com.example.springdocker.repository;

import com.example.springdocker.model.Yarn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-11
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@Repository
public interface YarnRepository extends MongoRepository<Yarn, String> {

 List<Yarn> findYarnByWool(boolean wool);
}
