package com.rodolpho.SEASolution.service.implementation;

import com.rodolpho.SEASolution.exception.ResourceNotFoundException;
import com.rodolpho.SEASolution.models.cargo;
import com.rodolpho.SEASolution.models.trabalhador;
import com.rodolpho.SEASolution.payment.DTO.trabalhadorDTO;
import com.rodolpho.SEASolution.payment.form.trabalhadorForm;
import com.rodolpho.SEASolution.repository.trabalhadorRepository;
import com.rodolpho.SEASolution.repository.cargoRepository;
import com.rodolpho.SEASolution.service.trabalhadorService;
import com.rodolpho.SEASolution.service.implementation.trabalhadorServiceImplement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class trabalhadorServiceImplement implements trabalhadorService {

    private final trabalhadorRepository trabalhadorRepository;

    private final cargoRepository cargoRepository;

    public trabalhadorServiceImplement(trabalhadorRepository trabalhadorRepository, cargoRepository cargoRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
        this.cargoRepository = cargoRepository;
    }

    @Override
    public trabalhadorDTO cadastrar(trabalhadorForm trabalhadorForm) {
        cargo cargo = buscarCargo(trabalhadorForm.getCargoId());

        trabalhador trabalhador = new trabalhador();
        trabalhador.setNome(trabalhadorForm.getNome());
        trabalhador.setCpf(trabalhadorForm.getCpf());
        trabalhador.setCargo(cargo);

        trabalhador trabalhadorSalvo = trabalhadorRepository.save(trabalhador);
        return new trabalhadorDTO(trabalhadorSalvo);
    }

    @Override
    public Page<trabalhadorDTO> listar(Pageable pageable) {
        return trabalhadorRepository.findAll(pageable).map(trabalhadorDTO::new);
    }

    @Override
    public trabalhadorDTO detalharPorId(UUID id) {
        trabalhador trabalhador = this.buscarPorId(id);
        return new trabalhadorDTO(trabalhador);
    }

    @Override
    public List<trabalhadorDTO> detalharPorNome(String nome) {
    List<trabalhador>trabalhadores = this.buscarPorNome(nome);
        return trabalhadores.stream().map(trabalhadorDTO::new).collect(Collectors.toList());
    }

    @Override
    public trabalhadorDTO detalharPorCpf(String cpf) {
    trabalhador trabalhador = this.buscarPorCpf(cpf);
        return new trabalhadorDTO(trabalhador);
    }

    @Override
    public trabalhadorDTO atualizar(UUID id, trabalhadorForm trabalhadorForm) {
        trabalhador trabalhador = this.buscarPorId(id);
        cargo cargo = this.buscarCargo(trabalhadorForm.getCargoId());

        trabalhador.setNome(trabalhadorForm.getNome());
        trabalhador.setCpf(trabalhadorForm.getCpf());
        trabalhador.setCargo(cargo);
        trabalhador trabalhadorAtualizado = trabalhadorRepository.save(trabalhador);
        return new trabalhadorDTO(trabalhadorAtualizado);
    }

    @Override
    public Boolean remover(UUID id) {
        trabalhador trabalhador = buscarPorId(id);
        trabalhadorRepository.delete(trabalhador);
        return Boolean.TRUE;
    }

    private trabalhador buscarPorId(UUID id) {
        return trabalhadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado!"));
    }

    private List<trabalhador> buscarPorNome(String nome) {
        return trabalhadorRepository.findByNome(nome);
    }

    private trabalhador buscarPorCpf(String cpf) {
        return trabalhadorRepository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado!"));
    }

    private cargo buscarCargo(UUID id) {
    return cargoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cargo: " + id + " não encontrado"));
    }
}
