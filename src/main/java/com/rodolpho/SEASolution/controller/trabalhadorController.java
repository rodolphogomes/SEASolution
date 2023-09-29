package com.rodolpho.SEASolution.controller;

import com.rodolpho.SEASolution.payment.DTO.trabalhadorDTO;
import com.rodolpho.SEASolution.payment.form.trabalhadorForm;
import com.rodolpho.SEASolution.service.implementation.trabalhadorServiceImplement;
import com.rodolpho.SEASolution.util.apiResponse;
import io.swagger.annotations.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/trabalhadores")
public class trabalhadorController {

    private final trabalhadorServiceImplement trabalhadorService;

    public trabalhadorController(trabalhadorServiceImplement trabalhadorService) {
        this.trabalhadorService = trabalhadorService;
    }

    @PostMapping
    public ResponseEntity<trabalhadorDTO> cadastrar(@RequestBody @Valid trabalhadorForm trabalhadorForm) {
        trabalhadorDTO trabalhadorDTO = trabalhadorService.cadastrar(trabalhadorForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabalhadorDTO);
    }

    @GetMapping
        public ResponseEntity<Page<trabalhadorDTO>>listar(@PageableDefault Pageable pageable) {
        Page<trabalhadorDTO> trabalhadorDTOPage = trabalhadorService.listar((org.springframework.data.domain.Pageable) pageable);
        return ResponseEntity.ok(trabalhadorDTOPage);
    }

    @GetMapping("/{id}")
        public ResponseEntity<trabalhadorDTO> detalharPorId(@PathVariable(value = "id") UUID id) {
            trabalhadorDTO trabalhadorDTO = trabalhadorService.detalharPorId(id);
            return ResponseEntity.ok(trabalhadorDTO);
        }

    @GetMapping("/nome")
        public ResponseEntity<List<trabalhadorDTO>> detalharPorNome(@PathVariable(value = "nome") String nome) {
            List<trabalhadorDTO>trabalhadorDTOList = trabalhadorService.detalharPorNome(nome);
            return ResponseEntity.ok(trabalhadorDTOList);
        }

    @GetMapping("/{cpf}")
        public ResponseEntity<trabalhadorDTO> detalharPorCPF(@PathVariable(value = "cpf") String cpf) {
            trabalhadorDTO trabalhadorDTO = trabalhadorService.detalharPorCpf(cpf);
            return ResponseEntity.ok(trabalhadorDTO);
        }

    @PutMapping("/{id}")
        public ResponseEntity<trabalhadorDTO> atualizar(@PathVariable(value = "id") UUID id, @RequestBody trabalhadorForm trabalhadorForm) {
            trabalhadorDTO trabalhadorDTO = trabalhadorService.atualizar(id, trabalhadorForm);
            return ResponseEntity.ok(trabalhadorDTO);
        }

    @DeleteMapping("/{id}")
        public ResponseEntity<apiResponse> remover(@PathVariable(value = "id") UUID id) {
            Boolean removido = trabalhadorService.remover(id);
            return ResponseEntity.ok(new apiResponse("Trabalhador: " + id + " removido" ,removido));
        }

    }

