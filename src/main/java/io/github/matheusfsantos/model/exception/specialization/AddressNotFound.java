package io.github.matheusfsantos.model.exception.specialization;

import io.github.matheusfsantos.model.exception.AppErrors;
import org.springframework.http.HttpStatus;

import java.util.List;

public class AddressNotFound extends AppErrors {

    public AddressNotFound(HttpStatus status, List<String> messages, String description) {
        super(status, messages, "Address Not Found", description);
    }

    public AddressNotFound(HttpStatus status, String message, String description) {
        super(status, message, "Address Not Found", description);
    }

}
