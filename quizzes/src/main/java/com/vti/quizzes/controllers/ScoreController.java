package com.vti.quizzes.controllers;

import com.vti.quizzes.services.ICommentService;
import com.vti.quizzes.services.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "quizzes/score")
public class ScoreController {
    @Autowired
    IScoreService scoreService;
}
