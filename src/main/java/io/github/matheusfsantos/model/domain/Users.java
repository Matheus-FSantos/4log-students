package io.github.matheusfsantos.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="tb_users")
public class Users implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String RA;

    @Column(length=50, nullable=false)
    private String name;

    @Column(length=8, nullable=false)
    private String cep;

    @Column(length=15, nullable=false)
    private String number;

    @Column(length=115)
    private String complement;

    @Column(nullable=false)
    private Double ado;

    @Column(nullable=false)
    private Double pi;

    @JsonFormat(pattern="HH:mm:ss dd/MM/yyyy")
    private LocalDateTime createdAt;

    @JsonFormat(pattern="HH:mm:ss dd/MM/yyyy")
    private LocalDateTime updatedAt;

    public Users() { }

    public Users(String RA, String name, String cep, String number, String complement, Double ado, Double pi, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.RA = RA;
        this.name = name;
        this.cep = cep;
        this.number = number;
        this.complement = complement;
        this.ado = ado;
        this.pi = pi;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Users{" +
                "RA='" + RA + '\'' +
                ", name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", ado=" + ado +
                ", pi=" + pi +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(RA, users.RA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RA);
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

    public String getCEP() {
        return cep;
    }

    public void updateCEP(String cep) {
        this.setCEP(cep);
    }

    private void setCEP(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void updateNumber(String number) {
        this.setNumber(number);
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void updateComplement(String complement) {
        this.setComplement(complement);
    }

    private void setComplement(String complement) {
        this.complement = complement;
    }

    public Double getADO() {
        return ado;
    }

    public void updateADO(Double ado) {
        this.setADO(ado);
    }

    private void setADO(Double ado) {
        this.ado = ado;
    }

    public Double getPI() {
        return pi;
    }

    public void updatePI(Double pi) {
        this.setPI(pi);
    }

    private void setPI(Double pi) {
        this.pi = pi;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void updateCreatedAt() {
        this.setCreatedAt(LocalDateTime.now());
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

    public void updateUpdatedAt() {
        this.setUpdatedAt(LocalDateTime.now());
    }
    public void updateUpdatedAt(LocalDateTime updatedAt) {
        this.setUpdatedAt(updatedAt);
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
