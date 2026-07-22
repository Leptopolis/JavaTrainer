package com.example.javatrainer.service;

import com.example.javatrainer.entity.Question;
import com.example.javatrainer.dto.QuestionRequestDto;
import com.example.javatrainer.repository.QuestionRepository;

import java.util.List;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
    public Question create(QuestionRequestDto request);
    public Question create(Question quesion);

    public Question update(Long id, QuestionRequestDto request);

    public void delete(Long id);

    public Question getById(Long id);

    public List<Question> getAll();
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class JavaTrainerServiceImpl implements JavaTrainerService{
    private final QuestionRepository repository;

    @Transactional
    @Override
    public Question create(QuestionRequestDto request){
        Question question = Question.builder()
                            .question(request.getQuestion())
                            .answers(request.getAnswers())
                            .correctAnswer(request.getCorrectAnswer())
                            .build();
        return repository.save(question);
    }

    @Transactional
    @Override
    public Question create(Question question){
        return repository.save(question);
    }

    @Transactional
    @Override
    public Question update(Long id, QuestionRequestDto request){
        Question question = repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Question is not found"));

        if(request.getQuestion() != null){
            question.setQuestion(request.getQuestion());
        }
        if(request.getAnswers() != null){
            question.setAnswers(request.getAnswers());
        }
        if(request.getCorrectAnswer() != null){
            question.setCorrectAnswer(request.getCorrectAnswer());
        }
        return repository.save(question);
    }

    @Transactional
    @Override
    public void delete(Long id){
        Question question = repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Question is not found"));
        repository.delete(question);
    }

    @Override
    public Question getById(Long id){
        Question question = repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Question is not found"));
        return question;
    }

    @Override
    public List<Question> getAll(){
        return repository.findAll();
    }


}