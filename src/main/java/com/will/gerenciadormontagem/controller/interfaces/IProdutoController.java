package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ProdutoDTO;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(ApiPaths.PRODUTO_PATH)
public interface IProdutoController {

    @PostMapping
    ResponseEntity<ProdutoDTO> incluir(@Valid @RequestBody ProdutoDTO produto);

    @GetMapping
    List<ProdutoDTO> listar();

    @PutMapping(OperationsPath.ID)
    void editar(@PathVariable(OperationsParam.ID) Integer id,
                @RequestBody ProdutoDTO produtoDTO);

    @GetMapping(OperationsPath.ID)
    ProdutoDTO findById(@PathVariable Integer id);

    @PutMapping(OperationsPath.PARENT_ID + "/promocao" + OperationsPath.ID)
    void ativarPromocoes(@PathVariable(OperationsParam.PARENT_ID) Integer idProduto,
                         @PathVariable(OperationsParam.ID) Integer idPromocao);

}
