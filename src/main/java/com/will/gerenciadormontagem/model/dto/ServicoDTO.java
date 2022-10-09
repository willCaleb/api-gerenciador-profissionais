package com.will.gerenciadormontagem.model.dto;

import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import lombok.Data;

@Data
public class ServicoDTO extends AbstractDTO{

    private Integer id;

    private String cod;

    private String nome;

    private String descricao;

    private Long preco;

    private Boolean ativo;

    private EnumTipoServico tipoServico;
}
