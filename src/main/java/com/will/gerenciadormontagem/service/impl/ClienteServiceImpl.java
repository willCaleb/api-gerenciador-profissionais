package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Cliente;
import com.will.gerenciadormontagem.repository.ClienteRepository;
import com.will.gerenciadormontagem.service.ClienteService;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import com.will.gerenciadormontagem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente incluir(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void editar(Integer idCliente, Cliente cliente) {

        Cliente clienteManaged = ObjectUtils.validate(clienteRepository.findById(idCliente));

        clienteManaged.setEnderecos(Utils.nvl(cliente.getEnderecos(), clienteManaged.getEnderecos()));
        clienteManaged.setNome(Utils.nvl(cliente.getNome(), clienteManaged.getNome()));
        clienteManaged.setTelefone(Utils.nvl(cliente.getTelefone(), clienteManaged.getTelefone()));
        clienteManaged.setWhatsapp(Utils.nvl(cliente.getWhatsapp(), clienteManaged.getWhatsapp()));

        clienteRepository.save(clienteManaged);
    }
}
