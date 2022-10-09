package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ProfissionalDTO;
import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(IProfissionalController.PATH)
@CrossOrigin(origins = "http://localhost:4200")
public interface IProfissionalController {
    String PATH = "/profissional";

    @GetMapping
    List<ProfissionalDTO> listAll();

    @PostMapping
    ProfissionalDTO incluir(@Valid @RequestBody ProfissionalDTO profissional);

    @PutMapping("/servico/{id}")
    void incluirServico(@PathVariable("id") Integer id,
                        @RequestBody ServicoDTO servico);

    @PutMapping("/{id}/servico/{idServico}")
    void incluirServico(@PathVariable("id") Integer id,
                        @PathVariable("idServico") Integer idServico);

    @PutMapping
    ProfissionalDTO incluirServico(ServicoDTO servicoDTO, ProfissionalDTO profissionalDTO);

    @PutMapping("/{id}")
    void editar(@PathVariable("id") Integer id,
                @RequestBody ProfissionalDTO profissionalDTO);

    @GetMapping(OperationsPath.ID)
    ProfissionalDTO findById(@PathVariable(OperationsParam.ID) Integer id);
}
