package io.github.matheusfsantos.model.dto.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheusfsantos.model.exception.AppErrors;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AppErrorsDTO {

    private UUID id;

    private HttpStatus status;

    private String type;

    private String description;

    private List<String> messages;

    @JsonFormat(pattern="HH:mm:ss dd/MM/yyyy")
    private LocalDateTime exceptionAt;

    public AppErrorsDTO(AppErrors appErrors) {
        this.id = appErrors.getId();
        this.status = appErrors.getStatus();
        this.type = appErrors.getType();
        this.description = appErrors.getDescription();
        this.messages = appErrors.getMessages();
        this.exceptionAt = appErrors.getExceptionAt();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public LocalDateTime getExceptionAt() {
        return exceptionAt;
    }

    public void setExceptionAt(LocalDateTime exceptionAt) {
        this.exceptionAt = exceptionAt;
    }

}
