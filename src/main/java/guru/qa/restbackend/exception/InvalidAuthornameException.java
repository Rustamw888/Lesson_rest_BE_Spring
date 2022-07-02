package guru.qa.restbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.GONE)
public class InvalidAuthornameException extends Error {
}
