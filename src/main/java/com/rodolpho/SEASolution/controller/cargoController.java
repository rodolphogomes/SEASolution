package com.rodolpho.SEASolution.controller;

import com.rodolpho.SEASolution.payment.DTO.cargoDTO;
import com.rodolpho.SEASolution.payment.form.cargoForm;
import com.rodolpho.SEASolution.service.implementation.cargoServiceImplement;
import com.rodolpho.SEASolution.util.apiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/cargos")
public class cargoController {

    private final cargoServiceImplement cargoService;

    public cargoController(cargoServiceImplement cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<cargoDTO> cadastrar(@RequestBody @Valid cargoForm cargoForm) {
        cargoDTO cargoDTO = cargoService.cadastrar(cargoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<cargoDTO>> listar(@PageableDefault Pageable pageable) {
        Page<cargoDTO> cargos = cargoService.listar(pageable);
        return ResponseEntity.ok(cargos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<cargoDTO> detalhar(@PathVariable(value = "id") UUID id) {
        cargoDTO cargoDto = cargoService.detalharPorId(id);
        return ResponseEntity.ok(cargoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<cargoDTO> atualizar(@PathVariable(value = "id") UUID id,@RequestBody @Valid cargoForm cargoForm) {
        cargoDTO cargoAtualizado = cargoService.atualizar(id, cargoForm);
        return ResponseEntity.ok(cargoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<apiResponse> remover(@PathVariable(value = "id") UUID id) {
        Boolean isremovido = cargoService.remover(id);
        return ResponseEntity.ok(new apiResponse("Cargo removido com sucesso!", isremovido));
    }


}
