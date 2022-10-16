package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IContaMovimentoController;
import com.will.gerenciadormontagem.model.dto.ContaMovimentoDTO;
import com.will.gerenciadormontagem.model.entity.ContaMovimento;
import com.will.gerenciadormontagem.service.ContaMovimentacaoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContaMovimentoController extends AbstractController<ContaMovimentacaoService> implements IContaMovimentoController {
    @Override
    public ContaMovimentoDTO incluir(Integer idConta, ContaMovimentoDTO contaMovimentoDTO) {
        ContaMovimento contaMovimento = convert(contaMovimentoDTO, ContaMovimento.class);
        return convert(getService().incluir(idConta, contaMovimento), ContaMovimentoDTO.class);
    }

    @Override
    @Transactional
    public List<ContaMovimentoDTO> listAll() {
        return convert(getService().listAll(), ContaMovimentoDTO.class);
    }

    @Override
    public void editar(Integer id, ContaMovimentoDTO contaMovimentoDTO) {
        ContaMovimento contaMovimento = convert(contaMovimentoDTO, ContaMovimento.class);
        getService().editar(id, contaMovimento);
    }
}
