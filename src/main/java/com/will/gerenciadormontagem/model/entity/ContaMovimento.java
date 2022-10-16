package com.will.gerenciadormontagem.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "conta_movimentacao")
public class ContaMovimento extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta_favorecido")
    private Conta contaFavorecido;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta_origem")
    private Conta contaOrigem;

    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;

    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

    @Column(name = "valor_transacao")
    private BigDecimal valorTransacao;
}
