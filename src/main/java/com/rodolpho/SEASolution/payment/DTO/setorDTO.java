package com.rodolpho.SEASolution.payment.DTO;

import com.rodolpho.SEASolution.models.setor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class setorDTO {

    private UUID id;
    private String nome;
    private List<cargoDTO> cargos = new ArrayList<>();

    public setorDTO() {

    }

    public setorDTO(setor setor) {
        this.id = setor.getId();
        this.nome = setor.getNome();
        if(!setor.getCargo().isEmpty() || setor.getCargo() != null) {
            this.cargos = setor.getCargo().stream().map(cargoDTO::new).collect(Collectors.toList());
        }
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

    public List<cargoDTO> getCargos() {
        return cargos;
    }

    public void setCargos(List<cargoDTO> cargos) {
        this.cargos = cargos;
    }
}
