package com.rodolpho.SEASolution.repository;

import com.rodolpho.SEASolution.models.cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface cargoRepository extends JpaRepository<cargo, UUID> {

    @Modifying
    @Query("delete from cargo where id = ?1")
    void deleteById(UUID cargoId);

    Optional<cargo> findByNome(String nome);
}
