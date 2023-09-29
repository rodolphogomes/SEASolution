package com.rodolpho.SEASolution.payment.DTO;

import com.rodolpho.SEASolution.models.cargo;

import java.math.BigDecimal;
import java.util.UUID;

public class cargoDTO {

    private UUID id;
    private String nome;
    private BigDecimal salario;
    private String setor;

    public cargoDTO() {

    }

    public cargoDTO(cargo cargo) {
        this.id = cargo.getId();
        this.nome = cargo.getNome();
        this.salario  = cargo.getSalario();
        this.setor  = cargo.getSetor().getNome();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
