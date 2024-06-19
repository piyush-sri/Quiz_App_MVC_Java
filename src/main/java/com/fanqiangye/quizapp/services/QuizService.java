package com.fanqiangye.quizapp.services;

import com.fanqiangye.quizapp.models.Question;
import com.fanqiangye.quizapp.models.Quiz;
import com.fanqiangye.quizapp.repositories.QuestionDAO;
import com.fanqiangye.quizapp.repositories.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = QuestionDAO.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("succes", HttpStatus.CREATED);
    }
}
