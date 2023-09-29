package com.rodolpho.SEASolution.payment.DTO;

import com.rodolpho.SEASolution.models.trabalhador;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.UUID;

public class trabalhadorDTO {

    private UUID id;
    private String nome;
    @CPF(message = "CPF Inválido!")
    private String cpf;

    private String cargo;
    private String setor;
    private BigDecimal salario;

    public trabalhadorDTO() {

    }

    public trabalhadorDTO(trabalhador trabalhador) {
        this.id = trabalhador.getId();
        this.nome = trabalhador.getNome();
        this.cpf = trabalhador.getCpf();
        this.cargo = trabalhador.getCargo().getNome();
        this.setor = trabalhador.getCargo().getSetor().getNome();
        this.salario = trabalhador.getCargo().getSalario();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
