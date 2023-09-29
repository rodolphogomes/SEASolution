package com.rodolpho.SEASolution.controller;

import com.rodolpho.SEASolution.payment.DTO.setorDTO;
import com.rodolpho.SEASolution.payment.form.setorForm;
import com.rodolpho.SEASolution.service.implementation.setorServiceImplement;
import com.rodolpho.SEASolution.util.apiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/setores")

public class setorController {

    private final setorServiceImplement setorService;

    public setorController(setorServiceImplement setorService) {this.setorService = setorService; }

    @PostMapping
    public ResponseEntity<setorDTO> cadastrar(@RequestBody @Valid setorForm setorForm) {
        setorDTO setorDTO = setorService.cadastrar(setorForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(setorDTO);
    }

    @GetMapping
    public ResponseEntity<List<setorDTO>> listar() {
        List<setorDTO> setorDTOList = setorService.listar();
        return ResponseEntity.ok(setorDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<setorDTO> buscarPorId(@PathVariable(value = "id") UUID id) {
        setorDTO setorDTO = setorService.detalharPorId(id);
        return ResponseEntity.ok(setorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<setorDTO> atualizar(@PathVariable(value = "id") UUID id, @RequestBody @Valid setorForm setorForm) {
        setorDTO setorDTO = setorService.atualizar(id, setorForm);
        return ResponseEntity.ok(setorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<apiResponse> remover(@PathVariable(value = "id") UUID id) {
        Boolean isremovido = setorService.remover(id);
        return ResponseEntity.ok(new apiResponse("Setor " + id + " foi removido com sucesso!" , isremovido));
    }



}
