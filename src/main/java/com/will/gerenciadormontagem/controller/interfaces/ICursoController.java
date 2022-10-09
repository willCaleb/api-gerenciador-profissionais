package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.entity.Curso;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(ICursoController.PATH)
public interface ICursoController {

    String PATH = "/curso";

    @GetMapping
    public List<Curso> list();

    @PostMapping
    public ResponseEntity<Curso> inserir(@RequestBody Curso curso);

    @GetMapping(OperationsPath.ID)
    public ResponseEntity<Curso> findById(@PathVariable(OperationsParam.ID) Integer id);
}
