package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ContaDTO;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.ApiPaths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPaths.CONTA_PATH)
public interface IContaController extends IAbstractController {

    @PostMapping
    ContaDTO incluir(@RequestBody ContaDTO contaDTO);

    @GetMapping("/list")
    List<ContaDTO> listar();

    @GetMapping(OperationsPath.ID)
    ContaDTO buscar(@PathVariable(OperationsParam.ID) Integer id);

}
