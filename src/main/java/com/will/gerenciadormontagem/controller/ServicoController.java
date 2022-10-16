package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IServicoController;
import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import com.will.gerenciadormontagem.service.ServicoService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ServicoController extends AbstractController<ServicoService> implements IServicoController {

    private ServicoService servicoService;

    @PostMapping
    public ServicoDTO incluir(ServicoDTO servicoDTO){
        return convert(getService().incluir(convert(servicoDTO, Servico.class)), ServicoDTO.class);
    }

    @Override
    public List<ServicoDTO> listAll() {
        return convert(getService().listAll(), ServicoDTO.class);
    }

    @Override
    public List<ServicoDTO> listarPorTipo(EnumTipoServico tipo) {
        return convert(getService().listarPorTipo(tipo), ServicoDTO.class);
    }

    @Override
    public ServicoDTO findServico(Integer id) {
        return convert(servicoService.findServico(id), ServicoDTO.class);
    }
}
