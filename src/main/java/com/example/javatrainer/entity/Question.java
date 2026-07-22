package com.example.javatrainer.entity;

import lombok.*;
import jakarta.persistence.*;

import com.example.javatrainer.converter.StringListConverter;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String category;

    @Column(unique = true, nullable = false)
    private String question;
    
    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "wrong_answers")
    private List<String> wrongAnswers;

    @Column()
    private String correctAnswer;
}