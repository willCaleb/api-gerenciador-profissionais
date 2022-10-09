package com.will.gerenciadormontagem.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class LojaDTO extends AbstractDTO{
    private Integer id;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private List<ProdutoDTO> produtos;
}
