package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.ICLienteController;
import com.will.gerenciadormontagem.model.dto.ClienteDTO;
import com.will.gerenciadormontagem.model.entity.Cliente;
import com.will.gerenciadormontagem.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteController extends AbstractController<ClienteService> implements ICLienteController {

    private final ClienteService clienteService;

    public ClienteDTO incluir(ClienteDTO clienteDto){
        return convert(clienteService.incluir(convert(clienteDto, Cliente.class)), ClienteDTO.class);
    }

    @Override
    @Transactional
    public List<ClienteDTO> getAll() {
        return convert(clienteService.getAll(), ClienteDTO.class);
    }

    @Override
    public void editar(Integer idCliente, Cliente cliente) {
        clienteService.editar(idCliente, cliente);
    }
}
