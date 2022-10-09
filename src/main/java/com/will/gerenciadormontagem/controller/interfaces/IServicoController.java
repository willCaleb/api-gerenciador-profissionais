package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.Paths;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(Paths.SERVICO_PATH)
@CrossOrigin(origins = Paths.CROSS_ORIGIN)
public interface IServicoController {

    @GetMapping(OperationsPath.ID)
    ServicoDTO findServico(@PathVariable(OperationsParam.ID) Integer id);

    @PostMapping
    ServicoDTO incluir(@RequestBody ServicoDTO servico);

    @GetMapping
    List<ServicoDTO> listAll();

    @GetMapping("/tipo/{tipo}")
    List<ServicoDTO> listarPorTipo(@PathVariable("tipo") EnumTipoServico tipo);
}
