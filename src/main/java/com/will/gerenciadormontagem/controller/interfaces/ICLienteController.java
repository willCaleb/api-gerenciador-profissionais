package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ClienteDTO;
import com.will.gerenciadormontagem.model.entity.Cliente;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.Paths;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(Paths.CLIENTE_PATH)
@CrossOrigin(origins = Paths.CROSS_ORIGIN)
public interface ICLienteController {

    @PostMapping
    ClienteDTO incluir(@Valid @RequestBody ClienteDTO cliente);

    @GetMapping("/list")
    List<ClienteDTO> getAll();

    @PutMapping(OperationsPath.ID)
    void editar(@PathVariable(OperationsParam.ID) Integer idCliente, @RequestBody Cliente cliente);
}
