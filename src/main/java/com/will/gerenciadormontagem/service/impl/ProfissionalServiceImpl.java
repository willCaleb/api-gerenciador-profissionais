package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.repository.ProfissionalRepository;
import com.will.gerenciadormontagem.service.ProfissionalService;
import com.will.gerenciadormontagem.service.ServicoService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfissionalServiceImpl extends AbstractServiceUtil implements ProfissionalService {

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
        Profissional profissional = validate(profissionalRepository.findById(idProfissional));
        profissional.getServicos().add(servico);
        profissionalRepository.save(profissional);
    }

    @Override
    @Transactional
    public void incluirServico(Integer idProfissional, Integer idServico) {
        Profissional profissional = validate(profissionalRepository.findById(idProfissional));
        Servico servico = servicoService.findServico(idServico);

        profissional.getServicos().add(servico);

        profissionalRepository.save(profissional);
    }

    @Override
    public void editar(Integer id, Profissional profissional) {
        Profissional profissionalManaged = validate(profissionalRepository.findById(id));

        profissionalManaged.setNome(nvl(profissional.getNome(), profissionalManaged.getNome()));
        profissionalManaged.setServicos(nvl(profissional.getServicos(), profissionalManaged.getServicos()));
        profissionalManaged.setTelefone(nvl(profissional.getTelefone(), profissionalManaged.getTelefone()));
        profissionalManaged.setWhatsapp(nvl(profissional.getWhatsapp(), profissionalManaged.getWhatsapp()));

        profissionalRepository.save(profissionalManaged);
    }

    @Override
    public Profissional buscarPorId(Integer idProfissional) {
        return validate(profissionalRepository.findById(idProfissional));
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
