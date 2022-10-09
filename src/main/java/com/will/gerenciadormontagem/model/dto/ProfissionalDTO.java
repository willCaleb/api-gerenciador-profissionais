package com.will.gerenciadormontagem.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProfissionalDTO extends AbstractDTO {

    private Integer id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String telefone;

    @NotBlank(message = "Whatsapp é obrigatório")
    private String whatsapp;

    List<ServicoDTO> servicos;

    List<ClienteDTO> clientes;
}
