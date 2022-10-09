package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ProdutoDTO;
import com.will.gerenciadormontagem.model.entity.Produto;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(IProdutoController.PATH)
@CrossOrigin(origins = "http://localhost:4200")
public interface IProdutoController {

    String PATH = "/produto";

    @PostMapping
    ResponseEntity<Produto> incluir(@RequestBody Produto produto);

    @GetMapping
    List<Produto> listar();

    @PutMapping(OperationsPath.ID)
    void editar(@PathVariable(OperationsParam.ID) Integer id,
                @RequestBody ProdutoDTO produtoDTO);

    @GetMapping(OperationsPath.ID)
    ProdutoDTO findById(@PathVariable Integer id);

}