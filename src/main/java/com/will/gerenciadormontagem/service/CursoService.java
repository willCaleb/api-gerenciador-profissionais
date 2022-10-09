package com.will.gerenciadormontagem.service;

import com.will.gerenciadormontagem.model.entity.Curso;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CursoService extends IAbstractService<Curso, Integer> {
    List<Curso> list();

    Curso inserir(Curso curso);

    ResponseEntity<Curso> findById(Integer id);
}
