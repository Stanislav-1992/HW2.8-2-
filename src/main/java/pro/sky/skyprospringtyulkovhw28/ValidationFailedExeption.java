package pro.sky.skyprospringtyulkovhw28;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationFailedExeption extends RuntimeException{
}
