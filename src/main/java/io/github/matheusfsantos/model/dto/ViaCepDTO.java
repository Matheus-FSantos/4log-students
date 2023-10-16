package io.github.matheusfsantos.model.dto;

import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

import java.io.Serial;
import java.io.Serializable;

public class ViaCepDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;

    private String cep;

    public ViaCepDTO() { }

    public ViaCepDTO(String logradouro, String bairro, String localidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void updateLogradouro(String logradouro) {
        this.setLogradouro(logradouro);
    }

    private void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void updateBairro(String bairro) {
        this.setBairro(bairro);
    }

    private void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void updateLocalidade(String localidade) {
        this.setLocalidade(localidade);
    }

    private void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void updateUf(String uf) {
        this.setUf(uf);
    }

    private void setUf(String uf) {
        this.uf = uf;
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

}
