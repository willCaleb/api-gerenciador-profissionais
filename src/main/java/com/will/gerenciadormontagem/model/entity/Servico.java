package com.will.gerenciadormontagem.model.entity;

import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "servico")
public class Servico extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cod_servico")
    private String cod;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "tipo")
    private EnumTipoServico tipoServico;

    @Column(name = "ativo")
    private Boolean ativo;
}
