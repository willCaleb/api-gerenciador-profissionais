package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class PromocaoDTO extends AbstractDTO{

    private Integer id;

    @NotBlank(message = "Nome não pode ser nulo nem vazio")
    private String nome;

    private BigDecimal porcentagem;

    private BigDecimal valor;

    private Date dataInicio;

    private Date dataFim;
}
