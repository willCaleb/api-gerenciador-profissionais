package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.ICursoController;
import com.will.gerenciadormontagem.model.entity.Curso;
import com.will.gerenciadormontagem.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CursoController implements ICursoController {

    private final CursoService cursoService;

    public List<Curso> list(){
        return cursoService.list();
    }

    public ResponseEntity<Curso> inserir(Curso curso){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.inserir(curso));
    }

    public ResponseEntity<Curso> findById(@PathVariable("id") Integer id){
        return cursoService.findById(id);
    }
}
