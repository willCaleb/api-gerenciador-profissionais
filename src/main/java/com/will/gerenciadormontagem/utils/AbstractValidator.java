package com.will.gerenciadormontagem.utils;

import java.util.HashMap;
import java.util.Map;

public class AbstractValidator {

//    private List<String> nullFields = new ArrayList<>();
    private Map<Object, String>  nullFields = new HashMap<>();

    public void add(Object field, String nome){
        if(field == null) {
            nullFields.put(field, nome);
        }
    }

    public Map<Object, String> validate(Map<Object, String> nullFields){
        if(!nullFields.isEmpty()){
            return nullFields;
        }
        return null;
    }
}
