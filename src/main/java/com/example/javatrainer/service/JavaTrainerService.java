package com.example.javatrainer.service;

import com.example.javatrainer.entity.Question;
import com.example.javatrainer.dto.QuestionRequestDto;

import java.util.List;

public interface JavaTrainerService{

    public Question create(QuestionRequestDto request);
    public Question create(Question quesion);

    public Question update(Long id, QuestionRequestDto request);

    public void delete(Long id);

    public Question getById(Long id);

    public List<Question> getAll();
}