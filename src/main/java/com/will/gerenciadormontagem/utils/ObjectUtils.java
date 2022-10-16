package com.will.gerenciadormontagem.utils;

import com.will.gerenciadormontagem.exception.ObjectNotFoundException;

import java.util.Optional;

public class ObjectUtils {

    public static <T> T  validate(Optional<T> t){
        if(t.isPresent()){
            return t.get();
        }
        throw new ObjectNotFoundException("Objeto não encontrado!");
    }

    public static boolean equals(Object a, Object b){
        return (a == b) || a.equals(b);
    }

    public static boolean isNotEquals(Object a, Object b){
        return !equals(a, b);
    }
}
