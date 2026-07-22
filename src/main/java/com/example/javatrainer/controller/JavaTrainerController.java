package com.example.javatrainer.controller;

import com.example.javatrainer.entity.Question;
import com.example.javatrainer.service.JavaTrainerService;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class JavaTrainerController{
    private final JavaTrainerService service;

    @GetMapping
    public List<Question> getAll(){
        return service.getAll();
    }

    @GetMapping("/category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        return service.getByCategory(category);
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id){
        return service.getById(id);
    }
}