package pro.sky.courseWork2.examinservice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.courseWork2.examinservice.domain.Question;
import pro.sky.courseWork2.examinservice.exception.QuestionAlredyExistsException;
import pro.sky.courseWork2.examinservice.exception.QuestionsAreEmptyException;
import pro.sky.courseWork2.examinservice.exception.QuestionsDatalsNull;

import java.util.Collection;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(new Question("Q1", "A1"));
        questionService.add(new Question("Q2", "A2"));
        questionService.add(new Question("Q3", "A3"));
    }

    @AfterEach
    public void afterEach() {
        new HashSet<>(questionService.getAll()).forEach(questionService::remove);


    }

    @Test
    public void add1Test() {
        int beforeCount=questionService.getAll().size();
        Question question = new Question("Q4", "A4");

        assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void add2Test() {
        int beforeCount=questionService.getAll().size();
        Question question = new Question("Q4", "A4");

        assertThat(questionService.add("Q4","A4"))
                .isEqualTo(question)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }
    @Test
    public void add1NegativeTest() {
        Question question = new Question("Q1", "A1");

        assertThatExceptionOfType(QuestionAlredyExistsException.class).
                isThrownBy(()->questionService.add(question));
    }
    @Test
    public void add2NegativeTest() {

        assertThatExceptionOfType(QuestionAlredyExistsException.class).
                isThrownBy(()->questionService.add("Q1", "A1"));
    }

    @Test
    public void removeTest() {
        int beforeCount=questionService.getAll().size();
        Question question = new Question("Q3", "A3");

        assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void getAllTest() {
        assertThat(questionService.getAll()).
                hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Q1", "A1"),
                        new Question("Q2", "A2"),
                        new Question("Q3", "A3")
                );
    }

    @Test
    public void getRandomQuestionsTest() {
        assertThat(questionService.getRandomQuestion())
        .isNotNull()
        .isIn(questionService.getAll());
    }

    @Test
    public void getRandomQuestionsNegativeTest() {
        afterEach();

        assertThatExceptionOfType(QuestionsAreEmptyException.class)
                .isThrownBy(questionService::getRandomQuestion);
    }

}
