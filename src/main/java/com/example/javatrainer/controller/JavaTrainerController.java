package com.example.javatrainer.controller;

import com.example.javatrainer.entity.Question;
import com.example.javatrainer.service.JavaTrainerService;

import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

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
    @GetMapping("/test")
    public List<QuestionDto> getTest(@RequestParam(defaultValue = "10") int count){
        List<Question> questions = service.getAll();
        Collections.shuffle(questions);
        return questions.stream()
                .limit(count)
                .map(q -> new QuestionDto(q.getId(), q.getQuestion(), q.getCorrectAnswer(), q.getWrongAnswers()))
                .collect(Collectors.toList());
    }

    public record QuestionDto(Integer id, String question, String correctAnswer, List<String> wrongAnswers){}
}