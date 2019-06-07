package com.example.comercialapi.controller;

import com.example.comercialapi.model.OportunidadeModel;
import com.example.comercialapi.repository.OportunidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    private OportunidadeRepository oportunidadeRepository;

    public OportunidadeController(OportunidadeRepository oportunidadeRepository) {
        this.oportunidadeRepository = oportunidadeRepository;
    }

    @GetMapping
    public List<OportunidadeModel> listar() {
        return oportunidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunidadeModel> buscar(@PathVariable Long id) {
        Optional<OportunidadeModel> optionalOportunidadeModel = oportunidadeRepository.findById(id);
        if (optionalOportunidadeModel.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalOportunidadeModel.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OportunidadeModel adicionar(@Valid @RequestBody OportunidadeModel oportunidadeModel) {

        Optional<OportunidadeModel> oportunidadeExistente =
                oportunidadeRepository.findByDescricaoAndNomeProspecto(oportunidadeModel.getDescricao(), oportunidadeModel.getNomeProspecto());
        if (oportunidadeExistente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma oportunidade para este prospecto com a mesma descrição.");
        }

        return oportunidadeRepository.save(oportunidadeModel);
    }

}
