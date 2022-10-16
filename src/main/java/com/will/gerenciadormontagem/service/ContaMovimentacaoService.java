package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Conta;
import com.will.gerenciadormontagem.model.entity.ContaMovimento;

import java.util.List;

public interface ContaMovimentacaoService extends IAbstractService<ContaMovimento, Integer> {

    ContaMovimento incluir(Integer idConta, ContaMovimento contaMovimentacao);

    void editar(Integer id, ContaMovimento contaMovimento);

    List<ContaMovimento> listAll();

}
