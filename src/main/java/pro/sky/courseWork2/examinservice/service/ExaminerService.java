package pro.sky.courseWork2.examinservice.service;

import pro.sky.courseWork2.examinservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
