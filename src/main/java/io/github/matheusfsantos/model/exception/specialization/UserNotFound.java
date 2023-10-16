package io.github.matheusfsantos.model.exception.specialization;

import io.github.matheusfsantos.model.exception.AppErrors;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserNotFound extends AppErrors {

    public UserNotFound(HttpStatus status, List<String> messages, String description) {
        super(status, messages, "User Not Found", description);
    }

    public UserNotFound(HttpStatus status, String message, String description) {
        super(status, message, "User Not Found", description);
    }

}
