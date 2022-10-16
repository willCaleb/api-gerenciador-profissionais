package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Conta;
import com.will.gerenciadormontagem.repository.ContaRepository;
import com.will.gerenciadormontagem.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContaServiceImpl extends AbstractServiceUtil implements ContaService {

    private ContaRepository contaRepository;

    @Override
    public JpaRepository<Conta, Integer> getRepository() {
        return this.contaRepository;
    }

    @Override
    public Conta incluir(Conta conta) {
        return getRepository().save(conta);
    }

    @Override
    public List<Conta> listarContas() {
        return getRepository().findAll();
    }

    @Override
    public Conta buscarConta(Integer id) {
        return validate(getRepository().findById(id));
    }

}
