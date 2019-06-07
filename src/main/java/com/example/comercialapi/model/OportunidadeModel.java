package com.example.comercialapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "oportunidade")
public class OportunidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 80)
    private String nomeProspecto;

    @NotEmpty
    @Size(max = 200)
    private String descricao;

    @Min(0)
    private BigDecimal valor;

}
