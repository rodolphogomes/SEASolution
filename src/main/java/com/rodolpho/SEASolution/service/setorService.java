package com.rodolpho.SEASolution.service;

import com.rodolpho.SEASolution.payment.DTO.setorDTO;
import com.rodolpho.SEASolution.payment.form.setorForm;

import java.util.List;
import java.util.UUID;

public interface setorService {

    setorDTO cadastrar(setorForm setorForm);
    List<setorDTO> listar();
    setorDTO detalharPorId(UUID id);
    setorDTO atualizar(UUID id, setorForm setorForm);
    Boolean remover(UUID id);
}
