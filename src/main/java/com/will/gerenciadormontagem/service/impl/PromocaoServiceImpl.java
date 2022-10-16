package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Promocao;
import com.will.gerenciadormontagem.repository.PromocaoRepository;
import com.will.gerenciadormontagem.service.PromocaoService;
import com.will.gerenciadormontagem.validator.Validator;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
@AllArgsConstructor
public class PromocaoServiceImpl extends AbstractServiceUtil implements PromocaoService {

    private final PromocaoRepository promocaoRepository;

    @Override
    public JpaRepository<Promocao, Integer> getRepository() {
        return this.promocaoRepository;
    }

    @Override
    public Promocao incluir(Promocao promocao) {
        Validator.validatePromocao(promocao);
        promocao.setDataInicio(Calendar.getInstance().getTime());
        return getRepository().save(promocao);
    }

    @Override
    public Promocao findById(Integer id) {
        return validate(promocaoRepository.findById(id));
    }
}
