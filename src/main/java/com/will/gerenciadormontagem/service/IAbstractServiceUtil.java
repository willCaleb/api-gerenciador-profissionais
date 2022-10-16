package com.will.gerenciadormontagem.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAbstractServiceUtil {
    <T> T  validate(Optional<T> t);

    <T> T nvl(T first, T second);

}
