package com.aravind.QuizService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizAnswerResponse {
	private Integer id;
	private String response;
}
