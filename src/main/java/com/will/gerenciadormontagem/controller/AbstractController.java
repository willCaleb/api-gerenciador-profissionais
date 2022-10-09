package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IAbstractController;
import com.will.gerenciadormontagem.service.IAbstractService;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

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
    @SuppressWarnings("unchecked")
    public <T, D> List<T> convert(List<?> list, Class<D> destClass) {
        List<D> convertList = new ArrayList<>();
        list.forEach( element -> {
            convertList.add(this.mapper.map(element, destClass));
        });
        return (List<T>) convertList;
    }

    @Override
    public JpaRepository<E, Integer> getRepository() {
        return null;
    }
}
