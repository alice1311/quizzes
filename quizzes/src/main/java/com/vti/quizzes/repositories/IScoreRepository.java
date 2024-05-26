package com.vti.quizzes.repositories;

import com.vti.quizzes.models.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IScoreRepository extends MongoRepository<Score, Long> {
}
