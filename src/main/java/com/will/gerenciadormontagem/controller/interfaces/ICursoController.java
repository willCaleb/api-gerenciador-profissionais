package com.will.gerenciadormontagem.controller.interfaces;

import com.will.gerenciadormontagem.model.dto.CursoDTO;
import com.will.gerenciadormontagem.utils.OperationsParam;
import com.will.gerenciadormontagem.utils.OperationsPath;
import com.will.gerenciadormontagem.utils.Paths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = Paths.CROSS_ORIGIN)
@RequestMapping(Paths.CURSO_PATH)
public interface ICursoController {

    @GetMapping
    List<CursoDTO> list();

    @PostMapping
    ResponseEntity<CursoDTO> inserir(@Valid @RequestBody CursoDTO curso);

    @GetMapping(OperationsPath.ID)
    ResponseEntity<CursoDTO> findById(@PathVariable(OperationsParam.ID) Integer id);
}
