package com.will.gerenciadormontagem.model.dto;

import lombok.Data;

@Data
public class ClienteDTO extends AbstractDTO{

    private Integer id;

    private String nome;

    private String telefone;

    private String whatsapp;

    private String endereco;
}
