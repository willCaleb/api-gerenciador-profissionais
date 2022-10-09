package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.service.IAbstractService;

import java.security.Provider;

public interface IAbstractController extends IAbstractService {

    Provider getService();
     <S, D> D convert(S source, Class<D> destClass);
}
