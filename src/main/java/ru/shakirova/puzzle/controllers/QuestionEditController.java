package ru.shakirova.puzzle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.shakirova.puzzle.entity.Question;

import java.util.List;

@Controller
public class QuestionEditController {

    private QuestionService questionService;

    @Autowired
    public QuestionEditController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "question")
    public String getQuestionPage(){
        return "question";
    }

    @RequestMapping(method = RequestMethod.GET, path = "questions")
    public String getQuestionsPage(Model model){
        List<Question> questions = questionRepository.getAllQuestions();
        model.addAttribute("questions", questions);
        return "questions";
    }
}
