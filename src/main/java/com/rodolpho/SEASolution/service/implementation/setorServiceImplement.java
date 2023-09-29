package com.rodolpho.SEASolution.service.implementation;

import com.rodolpho.SEASolution.exception.ResourceNotFoundException;
import com.rodolpho.SEASolution.payment.DTO.setorDTO;
import com.rodolpho.SEASolution.payment.form.setorForm;
import com.rodolpho.SEASolution.repository.setorRepository;
import com.rodolpho.SEASolution.models.setor;
import com.rodolpho.SEASolution.service.setorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

@Service
@Transactional
public class setorServiceImplement implements setorService {

    private final setorRepository setorRepository;

    public setorServiceImplement(setorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    @Override
    public setorDTO cadastrar(setorForm setorForm) {
        setor setor = new setor();
        setor.setNome(setorForm.getNome());

        setor setorSalvo = setorRepository.save(setor);
        return new setorDTO(setorSalvo);
    }

    @Override
    public List<setorDTO> listar() {
        return setorRepository.findAll().stream().map(setorDTO::new).collect(Collectors.toList());
    }

    @Override
    public setorDTO detalharPorId(UUID id) {
        setor setor = this.buscarSetorPorId(id);
        return new setorDTO(setor);
    }

    @Override
    public setorDTO atualizar(UUID id, setorForm setorForm) {
        setor setor = buscarSetorPorId(id);
        setor.setNome(setorForm.getNome());

        setor setorAtualizado = setorRepository.save(setor);
        return new setorDTO(setorAtualizado);
    }

    @Override
    public Boolean remover(UUID id) {
        setor setor = this.buscarSetorPorId(id);
        setorRepository.delete(setor);
        return TRUE;
    }

    private setor buscarSetorPorId(UUID id) {
        return setorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setor: " + id + " não encontrado"));
    }

    private setor buscarSetorPorNome(String nome) {
        return setorRepository.findByNome(nome).orElseThrow(() -> new ResourceNotFoundException("Setor: " + nome + " não encontrado!"));
    }
}

