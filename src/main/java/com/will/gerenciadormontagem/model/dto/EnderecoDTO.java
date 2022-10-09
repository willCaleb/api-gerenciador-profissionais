package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO extends AbstractDTO{

    private Integer id;

    private String cidade;

    private String estado;

    private String logradouro;

    private String complemento;

    private String numero;

    private boolean ativo;
}
