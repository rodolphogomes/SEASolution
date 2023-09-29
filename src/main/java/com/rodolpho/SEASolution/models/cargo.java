package com.rodolpho.SEASolution.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table( name = "TB_cargo")
public class cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "salario", nullable = false)
    private BigDecimal salario;

    @ManyToOne
    private setor setor;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<trabalhador> trabalhadores;

    public cargo() {

    }

    public cargo(UUID id, String nome, BigDecimal salario, setor setor, List<trabalhador> trabalhadores) {
        this.id = id;
        this.salario = salario;
        this.setor = setor;
        this.trabalhadores = trabalhadores;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public String toString() {
        return super.toString();
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

    public setor getSetor() {
        return setor;
    }

    public void setSetor(setor setor) {
        this.setor = setor;
    }

    public List<trabalhador> getTrabalhadores() {
        return trabalhadores;
    }

    public void setTrabalhadores(List<trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }
}
