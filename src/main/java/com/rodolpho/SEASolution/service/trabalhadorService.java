package com.rodolpho.SEASolution.service;

import com.rodolpho.SEASolution.payment.DTO.trabalhadorDTO;
import com.rodolpho.SEASolution.payment.form.trabalhadorForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface trabalhadorService {

    trabalhadorDTO cadastrar(trabalhadorForm trabalhadorForm);
    Page<trabalhadorDTO> listar(Pageable  pageable);
    trabalhadorDTO detalharPorId(UUID id);
    List<trabalhadorDTO> detalharPorNome(String nome);
    trabalhadorDTO detalharPorCpf(String cpf);
    trabalhadorDTO atualizar(UUID id, trabalhadorForm trabalhadorForm);
    Boolean remover(UUID id);
}
