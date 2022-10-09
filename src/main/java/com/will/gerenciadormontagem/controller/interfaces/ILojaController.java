package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.LojaDTO;
import com.will.gerenciadormontagem.model.entity.Loja;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ILojaController.PATH)
@CrossOrigin(origins = "http://localhost:4200")
public interface ILojaController {

    String PATH = "/loja";

    @GetMapping("/list")
    List<LojaDTO> findAll();

    @PostMapping
    ResponseEntity<Loja> incluir(@RequestBody Loja loja);
}
