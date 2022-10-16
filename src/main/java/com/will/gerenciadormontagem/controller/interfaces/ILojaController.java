package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.LojaDTO;
import com.will.gerenciadormontagem.model.entity.Loja;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPaths.LOJA_PATH)
@CrossOrigin(origins = ApiPaths.CROSS_ORIGIN)
public interface ILojaController {

    @GetMapping("/list")
    List<LojaDTO> findAll();

    @PostMapping
    ResponseEntity<Loja> incluir(@RequestBody Loja loja);

    @PutMapping
    void editar(@PathVariable(OperationsParam.ID) Integer id, LojaDTO lojaDTO);
}
