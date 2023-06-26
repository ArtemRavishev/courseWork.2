package pro.sky.courseWork2.examinservice.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.examinservice.domain.Question;
import pro.sky.courseWork2.examinservice.exception.IncorrectAmountOfQuestions;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectAmountOfQuestions();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
