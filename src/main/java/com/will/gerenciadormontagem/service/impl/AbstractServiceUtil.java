package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.service.IAbstractServiceUtil;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import com.will.gerenciadormontagem.utils.Utils;

import java.util.Optional;

public class AbstractServiceUtil<E, I> implements IAbstractServiceUtil {
    @Override
    public <T> T validate(Optional<T> t) {
        return ObjectUtils.validate(t);
    }

    @Override
    public <T> T nvl(T first, T second) {
        return Utils.nvl(first, second);
    }
}
