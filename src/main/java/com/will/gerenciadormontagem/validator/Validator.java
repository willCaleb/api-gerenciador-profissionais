package com.will.gerenciadormontagem.validator;

import com.will.gerenciadormontagem.exception.EmptyFieldException;
import com.will.gerenciadormontagem.model.entity.Promocao;
import com.will.gerenciadormontagem.utils.Utils;

public class Validator {

    public static void validatePromocao(Promocao promocao){
        if(Utils.isEmpty(promocao.getPorcentagem()) && Utils.isEmpty(promocao.getValor())){
            throw new EmptyFieldException("A promoção deve ter um valor ou uma porcentagem");
        }
    }
}
