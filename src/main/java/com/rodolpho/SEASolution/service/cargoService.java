package com.rodolpho.SEASolution.service;

import com.rodolpho.SEASolution.payment.DTO.cargoDTO;
import com.rodolpho.SEASolution.payment.form.cargoForm;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.UUID;

public interface cargoService {

    cargoDTO cadastrar(cargoForm cargoForm);
    Page<cargoDTO> listar(Pageable pageable);

    Page<cargoDTO> listar(org.springframework.data.domain.Pageable pageable);

    cargoDTO detalharPorId(UUID id);
    cargoDTO atualizar(UUID id, cargoForm cargoForm);
    Boolean remover(UUID id);
}
