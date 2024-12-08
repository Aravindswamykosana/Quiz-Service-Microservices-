package com.aravind.QuizService.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.QuizService.dto.Quiz;
import com.aravind.QuizService.dto.QuizAnswerResponse;
import com.aravind.QuizService.dto.QuizWrapper;
import com.aravind.QuizService.feign.QuizFeign;
import com.aravind.QuizService.repo.QuizRepo;


@Repository
public class QuizDao {
	@Autowired
	private QuizRepo qrepo;
	@Autowired(required = true)
	private QuizFeign feign;
	
	public Quiz createQuiz(String catagory,String title){
		List<Integer> questions = feign.generateQuestion(catagory).getBody().getData();
		Quiz q=new Quiz();
		q.setTitle(title);
		q.setQuestions(questions);
		return qrepo.save(q);
	}

	public List<QuizWrapper> getQuiz(int id) {
		Quiz db = qrepo.findById(id).get();
		if(db!=null) {
			List<Integer> li = db.getQuestions();
			List<QuizWrapper> df = feign.getQuestionsById(li).getBody().getData();
			return df;
		}
		return null;	
	}
	
//	public Quiz deleteQuiz(int id){
//		Optional<Quiz> db = quizRepo.findById(id);
//		if(db.isPresent()) {
//			 Quiz data = db.get();
//			 quizRepo.deleteById(id);
//			 return data;
//		}
//		return null;
//	}

	public int getQuizAnswer(Integer id, List<QuizAnswerResponse> response) {
		Quiz db = qrepo.findById(id).get();
		 Integer df = feign.getScore(response).getBody().getData();
		if(db!=null){
			return df;
		}
		else {
			return 0;
		}
	}
}
