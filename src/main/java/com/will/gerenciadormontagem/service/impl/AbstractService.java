package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.AbstractEntity;
import com.will.gerenciadormontagem.service.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.naming.Context;

public class AbstractService<E extends AbstractEntity<?>, I> implements IAbstractService {

    @Autowired
    private Context context;

    @Override
    public JpaRepository<E, I> getRepository() {
        return null;
    }
}
