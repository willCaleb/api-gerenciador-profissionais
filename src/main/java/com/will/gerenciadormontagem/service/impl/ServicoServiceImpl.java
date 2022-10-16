package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import com.will.gerenciadormontagem.repository.ServicoRepository;
import com.will.gerenciadormontagem.service.ServicoService;
import com.will.gerenciadormontagem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicoServiceImpl extends AbstractServiceUtil implements ServicoService {
    private final ServicoRepository servicoRepository;
    @Override
    public Servico incluir(Servico servico) {
        onPrepareInsert(servico);
        return servicoRepository.save(servico);
    }

    @Override
    public Servico findServico(Integer id) {
        return validate(servicoRepository.findById(id));
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
    public JpaRepository<Servico, Integer> getRepository() {
        return this.servicoRepository;
    }

    private void onPrepareInsert(Servico servico){
        if (Utils.isEmpty(servico.getAtivo())){
            servico.setAtivo(Boolean.TRUE);
        }
    }
}
