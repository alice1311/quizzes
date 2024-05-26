package com.vti.quizzes.repositories;

import com.vti.quizzes.models.Question;
import com.vti.quizzes.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IQuestionRepository extends MongoRepository<Question, Long> {
}
