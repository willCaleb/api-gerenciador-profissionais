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
public class ServicoController extends AbstractController implements IServicoController {

    private ServicoService servicoService;

    @PostMapping
    public ServicoDTO incluir(@RequestBody Servico servico){
        return (ServicoDTO) convert(servicoService.incluir(servico), ServicoDTO.class);
    }

    @Override
    public List<ServicoDTO> listAll() {
        List<Servico> servicos = servicoService.listAll();
        List<ServicoDTO> servicoDTOS = new ArrayList<>();
        servicos.forEach(servico ->{
            servicoDTOS.add((ServicoDTO) convert(servico, ServicoDTO.class));
        });
        return servicoDTOS;
    }

    @Override
    public List<ServicoDTO> listarPorTipo(EnumTipoServico tipo) {
        List<Servico> servicos = servicoService.listarPorTipo(tipo);
        List<ServicoDTO> servicoDTOS = new ArrayList<>();
        servicos.forEach(servico ->{
            servicoDTOS.add((ServicoDTO) convert(servico, ServicoDTO.class));
        });
        return servicoDTOS;
    }

    @Override
    public ServicoDTO findServico(Integer id) {
        return (ServicoDTO) convert(servicoService.findServico(id), ServicoDTO.class);
    }
}
