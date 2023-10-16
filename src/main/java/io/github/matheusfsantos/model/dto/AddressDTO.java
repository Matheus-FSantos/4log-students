package io.github.matheusfsantos.model.dto;

import java.io.Serial;
import java.io.Serializable;

public class AddressDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String number;

    private String complement;

    private ViaCepDTO address;

    public AddressDTO(String number, String complement, ViaCepDTO address) {
        this.number = number;
        this.complement = complement;
        this.address = address;
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

    public ViaCepDTO getAddress() {
        return address;
    }

    public void updateAddress(ViaCepDTO address) {
        this.setAddress(address);
    }

    private void setAddress(ViaCepDTO address) {
        this.address = address;
    }

}
