package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Curso;
import com.will.gerenciadormontagem.repository.CursoRepository;
import com.will.gerenciadormontagem.service.CursoService;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<Curso> list() {
        return getRepository().findAll();
    }

    @Override
    public Curso inserir(Curso curso) {
        return getRepository().save(curso);
    }

    @Override
    public ResponseEntity<Curso> findById(Integer id) {
         return ResponseEntity.ok(ObjectUtils.validate(getRepository().findById(id)));
    }

    @Override
    public JpaRepository<Curso, Integer> getRepository() {
        return this.cursoRepository;
    }
}
