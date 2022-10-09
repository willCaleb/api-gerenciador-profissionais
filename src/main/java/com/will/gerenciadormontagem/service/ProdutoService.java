package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Produto;

import java.util.List;

public interface ProdutoService extends IAbstractService<Produto, Integer>{

    Produto incluir(Produto produto);

    List<Produto> listAllDisponivel();

    void editar(Integer id, Produto produto);

    Produto findById(Integer id);
}
