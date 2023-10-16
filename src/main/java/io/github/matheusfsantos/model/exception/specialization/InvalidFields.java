package io.github.matheusfsantos.model.exception.specialization;

import io.github.matheusfsantos.model.exception.AppErrors;
import org.springframework.http.HttpStatus;

import java.util.List;

public class InvalidFields extends AppErrors {

    public InvalidFields(HttpStatus status, List<String> messages, String description) {
        super(status, messages, "Invalid Fields", description);
    }

    public InvalidFields(HttpStatus status, String message, String description) {
        super(status, message, "Invalid Fields", description);
    }

}
