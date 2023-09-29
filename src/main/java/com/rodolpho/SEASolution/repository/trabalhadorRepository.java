package com.rodolpho.SEASolution.repository;

import com.rodolpho.SEASolution.models.trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface trabalhadorRepository extends JpaRepository<trabalhador, UUID> {

    Optional<trabalhador> findByCpf(String cpf);

    @Query("Select * from trabalhador where nome like :keyword")
    List<trabalhador> findByNome(@Param("keyword") String nome);
}
