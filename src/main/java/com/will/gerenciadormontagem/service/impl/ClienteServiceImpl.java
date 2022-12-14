package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Cliente;
import com.will.gerenciadormontagem.repository.ClienteRepository;
import com.will.gerenciadormontagem.service.ClienteService;
import com.will.gerenciadormontagem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl extends AbstractServiceUtil implements ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente incluir(Cliente cliente) {

        return getRepository().save(cliente);
    }

    public List<Cliente> getAll() {
        return getRepository().findAll();
    }

    public void editar(Integer idCliente, Cliente cliente) {

        Cliente clienteManaged = validate(clienteRepository.findById(idCliente));

        clienteManaged.setEnderecos(nvl(cliente.getEnderecos(), clienteManaged.getEnderecos()));
        clienteManaged.setNome(nvl(cliente.getNome(), clienteManaged.getNome()));
        clienteManaged.setTelefone(nvl(cliente.getTelefone(), clienteManaged.getTelefone()));
        clienteManaged.setWhatsapp(nvl(cliente.getWhatsapp(), clienteManaged.getWhatsapp()));

        getRepository().save(clienteManaged);
    }

    @Override
    public JpaRepository<Cliente, Integer> getRepository() {
        return this.clienteRepository;
    }
}
