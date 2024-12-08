package com.aravind.QuizService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.QuizService.dto.Quiz;
import com.aravind.QuizService.dto.QuizAnswerResponse;
import com.aravind.QuizService.dto.QuizValue;
import com.aravind.QuizService.dto.QuizWrapper;
import com.aravind.QuizService.service.QuizService;
import com.aravind.quiz.exception.DataNotFoundException;
import com.aravind.quiz.util.ResponseStructure;

@RestController
@RequestMapping("quiz")
@EnableFeignClients
public class QuizController {
	
	@Autowired
	private QuizService service;
	
	@PostMapping("/createQuiz")
	public ResponseEntity<ResponseStructure<Quiz>> createQuiz(@RequestBody QuizValue values ){
		return service.createQuiz(values.getCatagory(),values.getTitle());
	}
	
	@GetMapping("/getQuiz")
	public ResponseEntity<ResponseStructure<List<QuizWrapper>>> getQuiz(@RequestParam int id) throws DataNotFoundException{
		return service.getQuiz(id);
	}
//	
//	@GetMapping("/deleteQuiz")
//	public ResponseEntity<ResponseStructure<Quiz>> deleteQuiz(@RequestParam int id) throws IdNotFoundException{
//		return service.deleteQuiz(id);
//	}
//	
	@PostMapping("/quizAnswer/{id}") //we have to use pathvariable here bcoz of based on id and post method
	public ResponseEntity<ResponseStructure<Integer>> quizAnswer(@PathVariable Integer id, @RequestBody List<QuizAnswerResponse> response) throws DataNotFoundException {
	    return service.getQuizAnswer(id, response);
	}

	
}
