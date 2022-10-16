package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ContaMovimentoDTO extends AbstractDTO{

    private Integer id;

    private ContaDTO contaFavorecido;

    private ContaDTO contaOrigem;

    private LocalDate dataInclusao;

    private LocalDate dataAlteracao;

    private BigDecimal valorTransacao;
}
