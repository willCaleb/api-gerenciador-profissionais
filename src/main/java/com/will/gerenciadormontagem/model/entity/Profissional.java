package com.will.gerenciadormontagem.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "profissional")
public class Profissional extends AbstractEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "whatsapp")
    private String whatsapp;

    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Servico> servicos;

    @OneToMany(fetch = FetchType.LAZY)
    List<Cliente> clientes;
}
