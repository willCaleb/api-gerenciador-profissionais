package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.ILojaController;
import com.will.gerenciadormontagem.model.dto.LojaDTO;
import com.will.gerenciadormontagem.model.entity.Loja;
import com.will.gerenciadormontagem.service.LojaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LojaController extends AbstractController<LojaService> implements ILojaController {
    private final LojaService lojaService;
    @Override
    public List<LojaDTO> findAll() {
        return convert(getService().findAllLoja(), LojaDTO.class);
    }

    @Override
    public ResponseEntity<Loja> incluir(Loja loja) {
        return ResponseEntity.status(HttpStatus.CREATED).body(getService().incluir(loja));
    }

    @Override
    public void editar(Integer id, LojaDTO lojaDTO) {
        Loja loja = convert(lojaDTO, Loja.class);
        getService().editar(id, loja);
    }
}
