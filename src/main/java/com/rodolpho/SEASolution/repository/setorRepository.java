package com.rodolpho.SEASolution.repository;

import com.rodolpho.SEASolution.models.setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface setorRepository extends JpaRepository<setor, UUID> {

    Optional<setor> findByNome(String nome);
}
