package com.will.gerenciadormontagem.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loja")
@Getter
@Setter
public class Loja extends AbstractEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cnpj")
    private String cnpj;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Produto> produtos;
}
