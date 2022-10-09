package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.ICursoController;
import com.will.gerenciadormontagem.model.dto.CursoDTO;
import com.will.gerenciadormontagem.model.entity.Curso;
import com.will.gerenciadormontagem.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CursoController extends AbstractController<CursoService> implements ICursoController {

    private final CursoService cursoService;

    public List<CursoDTO> list(){
        return convert(cursoService.list(), CursoDTO.class);
    }

    public ResponseEntity<CursoDTO> inserir(CursoDTO cursoDTO){
        Curso curso = convert(cursoDTO, Curso.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(convert(cursoService.inserir(curso), CursoDTO.class));
    }

    public ResponseEntity<CursoDTO> findById(@PathVariable("id") Integer id){
        CursoDTO cursoDTO = convert(cursoService.findById(id), CursoDTO.class);
        return ResponseEntity.status(HttpStatus.OK).body(cursoDTO);
    }
}
