package com.will.gerenciadormontagem.model.dto;

import com.will.gerenciadormontagem.model.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class ClienteDTO extends AbstractDTO{

    private Integer id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String telefone;

    @NotBlank(message = "Whatsapp é obrigatório")
    private String whatsapp;

    private List<EnderecoDTO> enderecos;
}
