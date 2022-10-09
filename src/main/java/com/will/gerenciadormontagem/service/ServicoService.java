package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;

import java.util.List;

public interface ServicoService extends IAbstractService<Servico, Integer>{

    Servico incluir(Servico servico);

    Servico findServico(Integer id);

    List<Servico> listAll();

    List<Servico> listarPorTipo(EnumTipoServico tipo);
}
