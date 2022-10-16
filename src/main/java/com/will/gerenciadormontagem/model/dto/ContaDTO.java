package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class ContaDTO extends AbstractDTO{

    private Integer id;

    @NotBlank(message = "O nome da conta não pode ser vazio ou nulo")
    private String nome;

    private List<ContaMovimentoDTO> movimentacoes;
}
