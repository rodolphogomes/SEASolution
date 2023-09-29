package com.rodolpho.SEASolution.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_setor")
public class setor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<cargo> cargos = new ArrayList<>();

    public setor() {

    }

    public setor(UUID id, String nome, List<cargo> cargo) {
        this.id = id;
        this.nome = nome;
        this.cargos = cargo;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        setor setor = (setor) object;
        return id.equals(setor.id) && nome.equals(setor.nome) && object.equals(cargos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cargos);
    }

    @Override
    public String toString() {
        return "setor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo=" + cargos +
                '}';
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

    public List <cargo> getCargo() {
        return cargos;
    }

    public void setCargo(List<com.rodolpho.SEASolution.models.cargo> cargo) {
        this.cargos = cargo;
    }
}
