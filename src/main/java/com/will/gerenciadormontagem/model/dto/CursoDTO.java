package com.will.gerenciadormontagem.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CursoDTO extends AbstractDTO{

    private Integer id;

    @NotBlank(message = "O nome do curso não pode estar vazio")
    private String name;

    @NotBlank(message = "A categoria do curso não pode estar vazia")
    private String category;

}
