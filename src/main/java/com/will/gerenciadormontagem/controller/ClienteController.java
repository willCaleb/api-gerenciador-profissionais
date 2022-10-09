package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.ICLienteController;
import com.will.gerenciadormontagem.model.dto.ClienteDTO;
import com.will.gerenciadormontagem.model.entity.Cliente;
import com.will.gerenciadormontagem.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteController extends AbstractController implements ICLienteController {

    private final ClienteService clienteService;

    public ClienteDTO incluir(ClienteDTO clienteDto){
        Cliente cliente = (Cliente) convert(clienteDto, Cliente.class);
        return (ClienteDTO) convert(clienteService.incluir(cliente), ClienteDTO.class);
    }

    @Override
    public List<ClienteDTO> getAll() {
        List<ClienteDTO> listDto = new ArrayList<>();
        clienteService.getAll().forEach(cliente -> {
            listDto.add((ClienteDTO) convert(cliente, ClienteDTO.class));
        });
        return listDto;
    }

    @Override
    public void editar(Integer idCliente, Cliente cliente) {
        clienteService.editar(idCliente, cliente);
    }
}
