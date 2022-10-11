package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.AbstractEntity;
import com.will.gerenciadormontagem.service.IAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.naming.Context;
import java.lang.reflect.ParameterizedType;

public class AbstractService<E extends AbstractEntity<?>, I> implements IAbstractService {

    @Autowired
    private Context context;

    @Override
    public JpaRepository<E, I> getRepository() {
//        return resolverRepositoryClass(Class<E> repository);
        return null;
    }

    @SuppressWarnings("unchecked")
    private Class<E> resolverRepositoryClass(Class<?> repositoryClass) {
        try {
            return (Class<E>) ((ParameterizedType) repositoryClass.getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
