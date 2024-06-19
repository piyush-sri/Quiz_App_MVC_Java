package com.fanqiangye.quizapp.repositories;

import com.fanqiangye.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT numQ", nativeQuery = true)
    static List<Question> findRandomQuestionsByCategory(String category, int numQ) {
    }


}
