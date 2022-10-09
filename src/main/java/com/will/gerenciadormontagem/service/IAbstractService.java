package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbstractService<E extends AbstractEntity<?>, I> {
    JpaRepository<E, I> getRepository();
}
