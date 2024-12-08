package com.aravind.QuizService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.QuizService.dto.QuizAnswerResponse;
import com.aravind.QuizService.dto.QuizWrapper;
import com.aravind.quiz.util.ResponseStructure;


@FeignClient("QUESTIONSERVICE")
public interface QuizFeign {
	@GetMapping("questions/generateQuestion")
	public ResponseEntity<ResponseStructure<List<Integer>>> generateQuestion(@RequestParam String catagory);

	
	@PostMapping("questions/getQuestionsById")
	public ResponseEntity<ResponseStructure<List<QuizWrapper>>> getQuestionsById(@RequestBody List<Integer> ids);
	
	@PostMapping("questions/getScore")
	public ResponseEntity<ResponseStructure<Integer>> getScore(@RequestBody List<QuizAnswerResponse> responses);
}
