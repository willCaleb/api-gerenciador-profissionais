package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IProfissionalController;
import com.will.gerenciadormontagem.model.dto.ProfissionalDTO;
import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.service.ProfissionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ProfissionalController extends AbstractController<ProfissionalService> implements IProfissionalController {

    @Override
    @Transactional
    public List<ProfissionalDTO> listAll() {
        return convert(getService().list(), ProfissionalDTO.class);
    }

    @Override
    public ProfissionalDTO incluir(ProfissionalDTO profissionalDTO){
        Profissional profissional = convert(profissionalDTO, Profissional.class);
        return convert(getService().incluir(profissional), ProfissionalDTO.class);
    }

    @Override
    public void incluirServico(Integer idProfissional, ServicoDTO servico) {
        getService().incluirServico(idProfissional, convert(servico, Servico.class));
    }

    @Override
    public void incluirServico(Integer idProfissional, Integer idServico) {
        getService().incluirServico(idProfissional, idServico);
    }

    @Override
    public ProfissionalDTO incluirServico(ServicoDTO servicoDTO, ProfissionalDTO profissionalDTO) {
        Servico servico = convert(servicoDTO, Servico.class);
        Profissional profissional = convert(profissionalDTO, Profissional.class);
        return convert(getService().adicionarServico(profissional, servico), ProfissionalDTO.class);
    }

    @Override
    public void editar(Integer id, ProfissionalDTO profissionalDTO) {
        getService().editar(id, convert(profissionalDTO, Profissional.class));
    }

    @Override
    @Transactional
    public ProfissionalDTO findById(Integer id) {
        return convert(getService().buscarPorId(id), ProfissionalDTO.class);
    }

    @Override
    public JpaRepository getRepository() {

        return this.getRepository();
    }
}
