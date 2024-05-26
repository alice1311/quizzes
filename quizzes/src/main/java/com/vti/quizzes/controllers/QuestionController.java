package com.vti.quizzes.controllers;

import com.vti.quizzes.jwt.JwtTokenStore;
import com.vti.quizzes.models.Question;
import com.vti.quizzes.models.User;
import com.vti.quizzes.request.LoginRequest;
import com.vti.quizzes.request.createQuestionForm;
import com.vti.quizzes.responses.ResponseObject;
import com.vti.quizzes.security.PasswordEncoder;
import com.vti.quizzes.services.ICommentService;
import com.vti.quizzes.services.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "quizzes/question")
public class QuestionController {
    @Autowired
    IQuestionService questionService;
    @PostMapping("/create")
    public ResponseEntity<?> createQuestion(@RequestBody Question questionCreate){
        ArrayList<String> answers = questionCreate.getAnswers();
        String correctAnswer = questionCreate.getCorrectAnswer();
        boolean isCorrectAnswerValid = false;
        for (String answer : answers) {
            if (answer.equals(correctAnswer)) {
                isCorrectAnswerValid = true;
                break;
            }
        }
        if (!isCorrectAnswerValid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject(400, null, "Correct answer is not in the list of answers."));
        }
        Question question = questionService.create(questionCreate);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, question, "success"));

    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable(name = "id") long id, @RequestBody Question questionupdate){
        Optional<Question> questionOptional = questionService.findById(id);
        if (questionOptional==null){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, id,"Not found Question!"));
        }
        Question updateQuestion = questionOptional.get();
        updateQuestion.setAnswers(questionupdate.getAnswers());
        updateQuestion.setQuestionName(questionupdate.getQuestionName());
        updateQuestion.setCorrectAnswer(questionupdate.getCorrectAnswer());
        questionService.update(updateQuestion);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, updateQuestion, "update success"));
    }
}
