package com.rodolpho.SEASolution.payment.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class trabalhadorForm {

    @NotBlank(message = "Formato inválido! Não deixar em branco")
    private String nome;
    @NotBlank(message = "Formato inválido! Não deixar em branco")
    @Length(min = 11, max = 11)
    private String cpf;
    @NotNull(message = "Formato inválido! Não deixar em branco")
    private UUID cargoId;

    public trabalhadorForm() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UUID getCargoId() {
        return cargoId;
    }

    public void setCargoId(UUID cargoId) {
        this.cargoId = cargoId;
    }
}
