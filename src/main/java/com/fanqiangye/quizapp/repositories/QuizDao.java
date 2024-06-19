package com.fanqiangye.quizapp.repositories;

import com.fanqiangye.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, integer> {
}
