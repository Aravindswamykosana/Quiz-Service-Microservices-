package com.aravind.quiz.util;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {
	private int status;
	private T data;
	private String message;
	private LocalDateTime dt;
}
