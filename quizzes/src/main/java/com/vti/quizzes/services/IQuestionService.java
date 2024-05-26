package com.vti.quizzes.services;

import com.vti.quizzes.models.Question;
import com.vti.quizzes.models.User;

import java.util.Optional;

public interface IQuestionService {
    public Question create(Question newQuestion);
    public Optional<Question> findById(Long id);
    public Question update(Question updateQuestion);
}
