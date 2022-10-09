package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IServicoController;
import com.will.gerenciadormontagem.model.dto.ServicoDTO;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import com.will.gerenciadormontagem.service.ServicoService;
import lombok.AllArgsConstructor;
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
    public ServicoDTO incluir(@RequestBody Servico servico){
        return convert(servicoService.incluir(servico), ServicoDTO.class);
    }

    @Override
    public List<ServicoDTO> listAll() {
        return convert(servicoService.listAll(), ServicoDTO.class);
    }

    @Override
    public List<ServicoDTO> listarPorTipo(EnumTipoServico tipo) {
        return convert(servicoService.listarPorTipo(tipo), ServicoDTO.class);
    }

    @Override
    public ServicoDTO findServico(Integer id) {
        return convert(servicoService.findServico(id), ServicoDTO.class);
    }
}
