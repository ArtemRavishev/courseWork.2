package pro.sky.courseWork2.examinservice.service;

import org.springframework.stereotype.Service;
import pro.sky.courseWork2.examinservice.domain.Question;
import pro.sky.courseWork2.examinservice.exception.QuestionAlredyExistsException;
import pro.sky.courseWork2.examinservice.exception.QuestionsAreEmptyException;
import pro.sky.courseWork2.examinservice.exception.QuestionsDatalsNull;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions= new HashSet<>();

    private final Random random= new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionAlredyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionsDatalsNull();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()){
            throw  new QuestionsAreEmptyException();
        }
      return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
