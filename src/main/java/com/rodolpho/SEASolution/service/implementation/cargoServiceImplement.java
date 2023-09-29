package com.rodolpho.SEASolution.service.implementation;

import com.rodolpho.SEASolution.exception.ResourceNotFoundException;
import com.rodolpho.SEASolution.payment.DTO.cargoDTO;
import com.rodolpho.SEASolution.payment.form.cargoForm;
import com.rodolpho.SEASolution.models.cargo;
import com.rodolpho.SEASolution.models.setor;
import com.rodolpho.SEASolution.repository.cargoRepository;
import com.rodolpho.SEASolution.repository.setorRepository;
import com.rodolpho.SEASolution.service.cargoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
public class cargoServiceImplement implements cargoService {

        private final cargoRepository cargoRepository;
        private final setorRepository setorRepository;

    public cargoServiceImplement(cargoRepository cargoRepository, setorRepository setorRepository) {
        this.cargoRepository = cargoRepository;
        this.setorRepository = setorRepository;
    }

    @Override
    public cargoDTO cadastrar(cargoForm cargoForm) {
        setor setor = this.buscarSetor(cargoForm.getSetorId());
        cargo cargo = new cargo();
        cargo.setNome(cargoForm.getNome());
        cargo.setSetor(setor);
        cargo.setSalario(cargoForm.getSalario());

        cargo cargoSalvo = cargoRepository.save(cargo);
        return new cargoDTO(cargoSalvo);
    }

    @Override
    public Page<cargoDTO> listar(java.awt.print.Pageable pageable) {
        return null;
    }

    @Override
    public Page<cargoDTO> listar(Pageable pageable) {
        return cargoRepository.findAll(pageable).map(cargoDTO::new);
    }

    @Override
    public cargoDTO detalharPorId(UUID id) {
        cargo cargo = this.buscarCargo(id);
        return new cargoDTO(cargo);
    }

    @Override
    public cargoDTO atualizar(UUID id, cargoForm cargoForm) {
        cargo cargo = this.buscarCargo(id);
        setor setor = this.buscarSetor(cargoForm.getSetorId());

        cargo.setNome(cargoForm.getNome());
        cargo.setSalario(cargoForm.getSalario());
        cargo.setSetor(setor);
        return new cargoDTO(cargo);
    }

    @Override
    public Boolean remover(UUID id) {
        cargo cargo = this.buscarCargo(id);
        cargoRepository.deleteById(id);
        return TRUE;
    }

    private cargo buscarCargo(UUID id) {
        return cargoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cargo: " + id + " não encontrado!"));
    }

    private setor buscarSetor(UUID id) {
        return setorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setor: " + id + " não encontrado!"));
    }
}
