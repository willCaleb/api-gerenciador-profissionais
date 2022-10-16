package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ProfissionalDTO;
import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.ApiPaths;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(ApiPaths.PROFISSIONAL_PATH)
public interface IProfissionalController {

    @GetMapping
    List<ProfissionalDTO> listAll();

    @PostMapping
    ProfissionalDTO incluir(@Valid @RequestBody ProfissionalDTO profissional);

    @PutMapping("/servico" + OperationsPath.ID)
    void incluirServico(@PathVariable(OperationsParam.ID) Integer id,
                        @RequestBody ServicoDTO servico);

    @PutMapping(OperationsPath.PARENT_ID + "/servico" + OperationsPath.ID)
    void incluirServico(@PathVariable(OperationsParam.PARENT_ID) Integer id,
                        @PathVariable(OperationsParam.ID) Integer idServico);

    @PutMapping
    ProfissionalDTO incluirServico(ServicoDTO servicoDTO, ProfissionalDTO profissionalDTO);

    @PutMapping(OperationsPath.ID)
    void editar(@PathVariable(OperationsParam.ID) Integer id,
                @RequestBody ProfissionalDTO profissionalDTO);

    @GetMapping(OperationsPath.ID)
    ProfissionalDTO findById(@PathVariable(OperationsParam.ID) Integer id);
}
