package io.github.matheusfsantos.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.matheusfsantos.model.domain.Users;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UsersDTO {

    private String RA;

    private String name;

    private String cep;

    private AddressDTO address;

    private Double ado;

    private Double pi;

    private Double finalNote;

    @JsonFormat(pattern="HH:mm:ss dd/MM/yyyy")
    private LocalDateTime createdAt;

    @JsonFormat(pattern="HH:mm:ss dd/MM/yyyy")
    private LocalDateTime updatedAt;

    private Boolean isUpdated;

    public UsersDTO() { }

    public UsersDTO(Users user, ViaCepDTO address) {
        this.RA = user.getRA();
        this.name = user.getName();
        this.cep = user.getCEP();
        this.address = new AddressDTO(user.getNumber(), user.getComplement(), address);
        this.ado = user.getADO();
        this.pi = user.getPI();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();

        this.isUpdated = !user.getCreatedAt().truncatedTo(ChronoUnit.SECONDS).isEqual(user.getUpdatedAt().truncatedTo(ChronoUnit.SECONDS));

        this.finalNote = (user.getPI() + user.getADO()) /2;
    }

    public String getRA() {
        return RA;
    }

    public void updateRA(String RA) {
        this.setRA(RA);
    }

    private void setRA(String RA) {
        this.RA = RA;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getCep() {
        return cep;
    }

    public void updateCep(String cep) {
        this.setCep(cep);
    }

    private void setCep(String cep) {
        this.cep = cep;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void updateAddress(AddressDTO address) {
        this.setAddress(address);
    }

    private void setAddress(AddressDTO address) {
        this.address = address;
    }

    public Double getAdo() {
        return ado;
    }

    public void updateAdo(Double ado) {
        this.setAdo(ado);
    }

    private void setAdo(Double ado) {
        this.ado = ado;
    }

    public Double getPi() {
        return pi;
    }

    public void updatePi(Double pi) {
        this.setPi(pi);
    }

    private void setPi(Double pi) {
        this.pi = pi;
    }

    public Double getFinalNote() {
        return finalNote;
    }

    public void updateFinalNote(Double finalNote) {
        this.setFinalNote(finalNote);
    }

    private void setFinalNote(Double finalNote) {
        this.finalNote = finalNote;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void updateCreatedAt(LocalDateTime createdAt) {
        this.setCreatedAt(createdAt);
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void updateUpdatedAt(LocalDateTime updatedAt) {
        this.setUpdatedAt(updatedAt);
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void updateUpdated(Boolean updated) {
        this.setUpdated(updated);
    }

    private void setUpdated(Boolean updated) {
        this.isUpdated = updated;
    }
}
