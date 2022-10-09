package com.will.gerenciadormontagem.model.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity<I extends Number> implements Serializable {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    Integer id;

//    Integer getId(){
//        this.id = I;
//    }

}
