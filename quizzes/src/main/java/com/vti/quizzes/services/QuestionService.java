package com.vti.quizzes.services;

import com.vti.quizzes.database.SequenceGeneratorService;
import com.vti.quizzes.models.Question;
import com.vti.quizzes.models.User;
import com.vti.quizzes.repositories.IQuestionRepository;
import com.vti.quizzes.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService{
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private IQuestionRepository repository;
    @Override
    public Question create(Question newQuestion) {
        Long id = sequenceGeneratorService.generateSequence(Question.SEQUENCE_NAME);
        newQuestion.setId(id);
        return repository.insert(newQuestion);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Question update(Question updateQuestion) {
        return repository.save(updateQuestion);
    }

}
