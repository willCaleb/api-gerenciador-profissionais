package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IContaController;
import com.will.gerenciadormontagem.model.dto.ContaDTO;
import com.will.gerenciadormontagem.model.entity.Conta;
import com.will.gerenciadormontagem.service.ContaService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContaController extends AbstractController<ContaService> implements IContaController {
    @Override
    public ContaDTO incluir(ContaDTO contaDTO) {
        Conta conta = convert(contaDTO, Conta.class);
        return convert(getService().incluir(conta), ContaDTO.class);
    }

    @Override
    public List<ContaDTO> listar() {
        return convert(getService().listarContas(), ContaDTO.class);
    }

    @Override
    public ContaDTO buscar(Integer id) {
        return convert(getService().buscarConta(id), ContaDTO.class);
    }
}
