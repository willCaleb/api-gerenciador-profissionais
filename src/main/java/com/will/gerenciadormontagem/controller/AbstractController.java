package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IAbstractController;
import com.will.gerenciadormontagem.service.IAbstractService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Provider;

public class AbstractController<E extends IAbstractService> implements IAbstractController {

    private Class<E> serviceClass;

    private final ModelMapper mapper = new ModelMapper();

    public Provider getService() {
        return null;
    }

    @Override
    public <S, D> D convert(S source, Class<D> destClass) {
        return this.mapper.map(source, destClass);
    }

    @Override
    public JpaRepository getRepository() {
        return null;
    }
}
