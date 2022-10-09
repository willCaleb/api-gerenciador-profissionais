package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import com.will.gerenciadormontagem.utils.Paths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(Paths.SERVICO_PATH)
@CrossOrigin(origins = Paths.CROSS_ORIGIN)
public interface IServicoController {

    @GetMapping("/{id}")
    ServicoDTO findServico(@PathVariable("id") Integer id);

    @PostMapping
    ServicoDTO incluir(@RequestBody Servico servico);

    @GetMapping
    List<ServicoDTO> listAll();

    @GetMapping("/tipo/{tipo}")
    List<ServicoDTO> listarPorTipo(@PathVariable("tipo") EnumTipoServico tipo);
}
