package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.repository.ProfissionalRepository;
import com.will.gerenciadormontagem.service.ProfissionalService;
import com.will.gerenciadormontagem.service.ServicoService;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import com.will.gerenciadormontagem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfissionalServiceImpl implements ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    private final ServicoService servicoService;

    @Override
    public Profissional incluir(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    @Override
    public List<Profissional> list() {
        return getRepository().findAll();
    }

    @Override
    public void incluirServico(Integer idProfissional, Servico servico) {
        Profissional profissional = ObjectUtils.validate(profissionalRepository.findById(idProfissional));
        profissional.getServicos().add(servico);
        profissionalRepository.save(profissional);
    }

    @Override
    @Transactional
    public void incluirServico(Integer idProfissional, Integer idServico) {
        Profissional profissional = ObjectUtils.validate(profissionalRepository.findById(idProfissional));
        Servico servico = servicoService.findServico(idServico);

        profissional.getServicos().add(servico);

        profissionalRepository.save(profissional);
    }

    @Override
    public void editar(Integer id, Profissional profissional) {
        Profissional profissionalManaged = ObjectUtils.validate(profissionalRepository.findById(id));

        profissionalManaged.setNome(Utils.nvl(profissional.getNome(), profissionalManaged.getNome()));
        profissionalManaged.setServicos(Utils.nvl(profissional.getServicos(), profissionalManaged.getServicos()));
        profissionalManaged.setTelefone(Utils.nvl(profissional.getTelefone(), profissionalManaged.getTelefone()));
        profissionalManaged.setWhatsapp(Utils.nvl(profissional.getWhatsapp(), profissionalManaged.getWhatsapp()));

        profissionalRepository.save(profissionalManaged);
    }

//    @Override
//    public List<Servico> listarServicosProfissional(Profissional profissional) {
//        return servicoService.listarPorProfissional(profissional);
//    }

    @Override
    public Profissional buscarPorId(Integer idProfissional) {
        return ObjectUtils.validate(profissionalRepository.findById(idProfissional));
    }

    @Override
    public Profissional adicionarServico(Profissional profissional, Servico servico) {
        profissional.getServicos().add(servico);
        return profissionalRepository.save(profissional);
    }

    @Override
    public JpaRepository<Profissional, Integer> getRepository() {
        return this.profissionalRepository;
    }
}
