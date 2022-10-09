package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IAbstractController;
import com.will.gerenciadormontagem.controller.interfaces.IProfissionalController;
import com.will.gerenciadormontagem.model.dto.ProfissionalDTO;
import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.service.ProfissionalService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ProfissionalController extends AbstractController<ProfissionalService> implements IProfissionalController {

    private final ProfissionalService profissionalService;

    @Override
    @Transactional
    public List<ProfissionalDTO> listAll() {
        List<Profissional> profissionais = profissionalService.list();
        List<ProfissionalDTO> profissionaisDto = new ArrayList<>();

        profissionais.forEach(profissional -> profissionaisDto
                .add(convert(profissional, ProfissionalDTO.class)));
        return profissionaisDto;
    }

    @Override
    public ProfissionalDTO incluir(ProfissionalDTO profissionalDTO){
        Profissional profissional = convert(profissionalDTO, Profissional.class);
        return convert(profissionalService.incluir(profissional), ProfissionalDTO.class);
    }

    @Override
    public void incluirServico(Integer idProfissional, ServicoDTO servico) {
        profissionalService.incluirServico(idProfissional, convert(servico, Servico.class));
    }

    @Override
    public void incluirServico(Integer idProfissional, Integer idServico) {
        profissionalService.incluirServico(idProfissional, idServico);
    }

    @Override
    public ProfissionalDTO incluirServico(ServicoDTO servicoDTO, ProfissionalDTO profissionalDTO) {
        Servico servico = convert(servicoDTO, Servico.class);
        Profissional profissional = convert(profissionalDTO, Profissional.class);
        return convert(profissionalService.adicionarServico(profissional, servico), ProfissionalDTO.class);
    }

    @Override
    public void editar(Integer id, ProfissionalDTO profissionalDTO) {
        profissionalService.editar(id, convert(profissionalDTO, Profissional.class));
    }

    @Override
    @Transactional
    public ProfissionalDTO findById(Integer id) {
        return convert(profissionalService.buscarPorId(id), ProfissionalDTO.class);
    }

    @Override
    public JpaRepository getRepository() {

        return this.getRepository();
    }
}
