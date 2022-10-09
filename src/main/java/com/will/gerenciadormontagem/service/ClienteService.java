package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente incluir(Cliente cliente);

    List<Cliente> getAll();

    void editar(Integer idCliente, Cliente cliente);
}
