package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LojaDTO extends AbstractDTO{
    private Integer id;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private List<ProdutoDTO> produtos;

    private List<EnderecoDTO> enderecos;
}
