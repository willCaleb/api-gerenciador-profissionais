package com.will.gerenciadormontagem.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO extends AbstractDTO{

    private Integer id;

    private String cod;

    private String nome;

    private BigDecimal preco;

    private Boolean disponivel;
}
