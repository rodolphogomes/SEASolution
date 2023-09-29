package com.rodolpho.SEASolution.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_trabalhador")
public class trabalhador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "cpf", unique = true)
    private String cpf;

    @ManyToOne
    private cargo cargo;

    public trabalhador() {

    }

    public trabalhador(UUID id, String nome, String cpf, com.rodolpho.SEASolution.models.cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
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

    public cargo getCargo() {
        return cargo;
    }

    public void setCargo(cargo cargo) {
        this.cargo = cargo;
    }
}


