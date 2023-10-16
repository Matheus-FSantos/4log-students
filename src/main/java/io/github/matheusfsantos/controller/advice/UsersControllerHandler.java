package io.github.matheusfsantos.controller.advice;

import io.github.matheusfsantos.model.dto.exception.AppErrorsDTO;
import io.github.matheusfsantos.model.exception.AppErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsersControllerHandler {

    @ExceptionHandler(AppErrors.class)
    public ResponseEntity<AppErrorsDTO> handleAppExceptions(AppErrors appErrors) {
        AppErrorsDTO dto = new AppErrorsDTO(appErrors);
        return ResponseEntity.status(dto.getStatus()).body(dto);
    }

}
