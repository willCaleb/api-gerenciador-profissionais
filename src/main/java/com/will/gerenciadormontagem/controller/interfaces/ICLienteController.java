package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.ClienteDTO;
import com.will.gerenciadormontagem.model.entity.Cliente;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ICLienteController.PATH)
@CrossOrigin(origins = "http://localhost:4200")
public interface ICLienteController {
    String PATH = "/cliente";

    @PostMapping
    ClienteDTO incluir(@RequestBody ClienteDTO cliente);

    @GetMapping("/list")
    List<ClienteDTO> getAll();

    @PutMapping(OperationsPath.ID)
    void editar(@PathVariable(OperationsParam.ID) Integer idCliente, @RequestBody Cliente cliente);
}
