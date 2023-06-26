package pro.sky.courseWork2.examinservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QuestionAlredyExistsException extends RuntimeException{
}
