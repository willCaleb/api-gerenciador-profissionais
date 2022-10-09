package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import com.will.gerenciadormontagem.repository.ServicoRepository;
import com.will.gerenciadormontagem.service.ServicoService;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicoServiceImpl implements ServicoService {
    private final ServicoRepository servicoRepository;
    @Override
    public Servico incluir(Servico servico) {
        System.out.println();
        return servicoRepository.save(servico);
    }

    @Override
    public Servico findServico(Integer id) {
        return ObjectUtils.validate(servicoRepository.findById(id));
    }

    @Override
    public List<Servico> listAll() {
        return servicoRepository.findAll();
    }

    @Override
    public List<Servico> listarPorTipo(EnumTipoServico tipo) {
        return servicoRepository.findAllServicosTipo(tipo);
    }

    @Override
    public List<Servico> listarPorProfissional(Profissional profissional) {
        return null;
    }
}
