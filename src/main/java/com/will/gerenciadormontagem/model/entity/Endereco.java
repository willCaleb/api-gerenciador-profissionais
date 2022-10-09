package com.will.gerenciadormontagem.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "numero")
    private String numero;

    @Column(name = "ativo")
    private boolean ativo;
}
