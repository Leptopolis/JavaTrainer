package com.example.javatrainer.dto;

import lombok.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequestDto{
    @NotBlank(message = "Question must not be null")
    private String question;

    @NotBlank(message = "Question must have answers")
    private List<String> answers;

    @Positive(message = "CorrectAnswer must be positive")
    private Integer correctAnswer;
}