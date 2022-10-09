package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Loja;

import java.util.List;

public interface LojaService extends IAbstractService<Loja, Integer> {

    Loja incluir(Loja loja);

    void editar(Integer id, Loja loja);

    List<Loja> findAllLoja();

    Loja findById(Integer id);
}
