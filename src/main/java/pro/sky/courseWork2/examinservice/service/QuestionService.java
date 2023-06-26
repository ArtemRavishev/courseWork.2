package pro.sky.courseWork2.examinservice.service;

import pro.sky.courseWork2.examinservice.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();






}
