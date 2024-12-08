package com.aravind.QuizService.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.QuizService.dto.Quiz;


public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
