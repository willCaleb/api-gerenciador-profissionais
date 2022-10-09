package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProfissionalService extends IAbstractService<Profissional, Integer>{

    Profissional incluir(Profissional profissional);

    List<Profissional> list();

    void incluirServico(Integer idProfissional, Servico servico);

    void incluirServico(Integer idProfissional, Integer idServico);

    void editar(Integer id, Profissional profissional);

    Profissional buscarPorId(Integer idProfissional);

    Profissional adicionarServico(Profissional profissional, Servico servico );
}
