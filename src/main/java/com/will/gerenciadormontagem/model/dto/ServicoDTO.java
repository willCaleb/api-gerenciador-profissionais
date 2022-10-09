package com.will.gerenciadormontagem.model.dto;

import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ServicoDTO extends AbstractDTO{

    private Integer id;

    @NotBlank(message = "Código é obrigatório")
    private String cod;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatório")
    private String descricao;

    @NotBlank(message = "Preço é obrigatório")
    private Long preco;

    private Boolean ativo;

    @NotBlank(message = "Tipo de serviçoe é obrigatório")
    private EnumTipoServico tipoServico;
}
