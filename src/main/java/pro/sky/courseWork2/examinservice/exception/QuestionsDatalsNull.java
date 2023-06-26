package pro.sky.courseWork2.examinservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionsDatalsNull extends RuntimeException{
}
