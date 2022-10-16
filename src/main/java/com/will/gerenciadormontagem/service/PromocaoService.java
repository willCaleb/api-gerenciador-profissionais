package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Promocao;
import org.springframework.stereotype.Service;


public interface PromocaoService extends IAbstractService<Promocao, Integer>{

    Promocao incluir(Promocao promocao);

    Promocao findById(Integer id);
}
