package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProdutoDTO extends AbstractDTO{

    private Integer id;

    @NotBlank(message = "Código é obrigatório")
    private String cod;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Preço é obrigatório")
    private BigDecimal preco;

    private Boolean disponivel;

    private List<PromocaoDTO> promocoes;
}
