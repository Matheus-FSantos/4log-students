package io.github.matheusfsantos.model.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class AppErrors extends Exception {

    private UUID id;

    private HttpStatus status;

    private String type;

    private String description;

    private List<String> messages;

    private LocalDateTime exceptionAt;

    public AppErrors(HttpStatus status, List<String> messages, String type, String description) {
        this.id = UUID.randomUUID();
        this.status = status;
        this.messages = messages;
        this.type = type;
        this.description = description;
        this.exceptionAt = LocalDateTime.now();
    }

    public AppErrors(HttpStatus status, String message, String type, String description) {
        this.id = UUID.randomUUID();
        this.status = status;
        this.type = type;
        this.description = description;
        this.messages = Collections.singletonList(message);
        this.exceptionAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    private void updateId(UUID id) {
        this.setId(id);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public HttpStatus getStatus() {
        return status;
    }

    private void updateStatus(HttpStatus status) {
        this.setStatus(status);
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getMessages() {
        return messages;
    }

    private void updateMessages(List<String> messages) {
        this.setMessages(messages);
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public LocalDateTime getExceptionAt() {
        return exceptionAt;
    }

    private void updateExceptionAt(LocalDateTime exceptionAt) {
        this.setExceptionAt(exceptionAt);
    }

    public void setExceptionAt(LocalDateTime exceptionAt) {
        this.exceptionAt = exceptionAt;
    }

    public String getType() {
        return type;
    }

    private void updateType(String type) {
        this.setType(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    private void updateDescription(String description) {
        this.setDescription(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

}