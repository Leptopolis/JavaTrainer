package com.example.javatrainer.entity;

import lombok.*;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "Question")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String question;
    
    @Convert
    @Column(columnDefinition = "answers")
    private List<String> answers;

    @Column()
    private int correctAnswer;
}