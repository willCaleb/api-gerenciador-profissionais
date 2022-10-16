package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.PromocaoDTO;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.ApiPaths;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(ApiPaths.PROMOCAO_PATH)
public interface IPromocaoController {

    @PostMapping
    PromocaoDTO incluir(@Valid @RequestBody PromocaoDTO promocaoDTO);

    @GetMapping("/produto" + OperationsPath.ID)
    List<PromocaoDTO> listarPorProduto(@PathVariable(OperationsParam.ID) Integer idProduto);

    @GetMapping(OperationsPath.ID)
    PromocaoDTO buscarPromocao(@PathVariable(OperationsParam.ID) Integer id);

    @GetMapping("/list")
    List<PromocaoDTO> listAll();

    @PutMapping
    void editar(@PathVariable(OperationsParam.ID) Integer id,
                @RequestBody PromocaoDTO promocaoDTO);
}
