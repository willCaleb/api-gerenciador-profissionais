package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Curso;
import com.will.gerenciadormontagem.repository.CursoRepository;
import com.will.gerenciadormontagem.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public List<Curso> list() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso inserir(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public ResponseEntity<Curso> findById(Integer id) {
         return cursoRepository.findById(id)
                 .map(curso -> ResponseEntity.ok(curso))
                 .orElse(ResponseEntity.notFound().build());
    }
}
