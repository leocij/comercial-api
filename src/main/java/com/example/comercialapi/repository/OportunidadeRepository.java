package com.example.comercialapi.repository;

import com.example.comercialapi.model.OportunidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OportunidadeRepository extends JpaRepository<OportunidadeModel, Long> {

    Optional<OportunidadeModel> findByDescricaoAndNomeProspecto(String descricao, String nomeProspecto);

}
