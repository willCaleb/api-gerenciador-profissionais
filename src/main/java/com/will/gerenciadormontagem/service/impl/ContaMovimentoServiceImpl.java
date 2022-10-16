package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Conta;
import com.will.gerenciadormontagem.model.entity.ContaMovimento;
import com.will.gerenciadormontagem.repository.ContaMovimentacaoRepository;
import com.will.gerenciadormontagem.service.ContaMovimentacaoService;
import com.will.gerenciadormontagem.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ContaMovimentoServiceImpl extends AbstractServiceUtil implements ContaMovimentacaoService {

    private final ContaMovimentacaoRepository contaMovimentacaoRepository;

    private final ContaService contaService;

    @Override
    @Transactional
    public ContaMovimento incluir(Integer idConta, ContaMovimento contaMovimento) {

        Conta contaOrigem = contaService.buscarConta(idConta);
        Conta contaDestino = contaService.buscarConta(contaMovimento.getContaFavorecido().getId());
        contaMovimento.setContaFavorecido(contaDestino);
        contaMovimento.setContaOrigem(contaOrigem);
        contaMovimento.setDataInclusao(LocalDate.now());
        return getRepository().save(contaMovimento);
    }

    @Override
    public void editar(Integer id, ContaMovimento contaMovimento) {
        ContaMovimento movimentoManaged = validate(getRepository().findById(id));

        movimentoManaged.setContaFavorecido(nvl(contaMovimento.getContaFavorecido(), movimentoManaged.getContaFavorecido()));
        movimentoManaged.setValorTransacao(nvl(contaMovimento.getValorTransacao(), movimentoManaged.getValorTransacao()));
        movimentoManaged.setDataAlteracao(LocalDate.now());

        getRepository().save(movimentoManaged);
    }

    @Override
    public List<ContaMovimento> listAll() {
        return getRepository().findAll();
    }


    @Override
    public JpaRepository<ContaMovimento, Integer> getRepository() {
        return this.contaMovimentacaoRepository;
    }
}
