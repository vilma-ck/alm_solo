package com.example.springdocker.controller;

import com.example.springdocker.model.Yarn;
import com.example.springdocker.service.YarnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vilma Couturier Kaijser
 * Date: 2021-05-11
 * Project: spring-docker-demo
 * Copyright: MIT
 */
@RequiredArgsConstructor
@RestController
public class YarnController {

 private final YarnService service;

 // hämta alla garner till lista
 @GetMapping("/yarns")
 public List<Yarn> getYarns(){
  return service.getYarns();
 }

 @PostMapping("/foods")
 public void saveNewYarn(@RequestBody Yarn yarn){
  service.saveNewYarn(yarn);
 }

 @GetMapping("/foods/wool")
 public List<String> getWoolYarns(){
  return service.getWoolYarns();
 }
}
