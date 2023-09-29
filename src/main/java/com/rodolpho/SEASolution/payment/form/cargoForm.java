package com.rodolpho.SEASolution.payment.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public class cargoForm {

    @NotBlank
    private String nome;
    @NotNull
    private UUID setorId;
    @NotNull
    private BigDecimal salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getSetorId() {
        return setorId;
    }

    public void setSetorId(UUID setorId) {
        this.setorId = setorId;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}