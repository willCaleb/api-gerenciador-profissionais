package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.dto.ContaDTO;
import com.will.gerenciadormontagem.model.entity.Conta;

import java.util.List;

public interface ContaService extends IAbstractService<Conta, Integer> {

    Conta incluir(Conta conta);

    List<Conta> listarContas();

    Conta buscarConta(Integer id);

}
