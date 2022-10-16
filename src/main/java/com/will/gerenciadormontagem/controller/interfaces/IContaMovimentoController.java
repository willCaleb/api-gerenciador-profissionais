package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ContaMovimentoDTO;
import com.will.gerenciadormontagem.utils.ApiPaths;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(IContaMovimentoController.CONTA_MOVIMENTO_PATH)
public interface IContaMovimentoController {
    String CONTA_MOVIMENTO_PATH = ApiPaths.CONTA_PATH + OperationsPath.ID + "/movimento";

    @PostMapping
    ContaMovimentoDTO incluir(@PathVariable(OperationsParam.ID) Integer idConta,
                              @RequestBody ContaMovimentoDTO contaMovimentoDTO);

    @GetMapping
    List<ContaMovimentoDTO> listAll();

    @PutMapping(OperationsPath.ID)
    void editar(@PathVariable(OperationsParam.ID) Integer id,
                @RequestBody ContaMovimentoDTO contaMovimentoDTO);
}
