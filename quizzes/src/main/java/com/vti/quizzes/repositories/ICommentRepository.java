package com.vti.quizzes.repositories;

import com.vti.quizzes.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICommentRepository extends MongoRepository<Comment, Long> {
}
