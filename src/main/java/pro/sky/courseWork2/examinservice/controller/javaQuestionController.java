package pro.sky.courseWork2.examinservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.courseWork2.examinservice.domain.Question;
import pro.sky.courseWork2.examinservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class javaQuestionController {

    private final QuestionService questionService;

    public javaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQustion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }
    @GetMapping("/remove")
    public Question removeQustion(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping("/find")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
