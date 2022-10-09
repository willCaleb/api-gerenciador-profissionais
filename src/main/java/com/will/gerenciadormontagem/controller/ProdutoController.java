package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IProdutoController;
import com.will.gerenciadormontagem.model.dto.ProdutoDTO;
import com.will.gerenciadormontagem.model.entity.Produto;
import com.will.gerenciadormontagem.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProdutoController extends AbstractController<ProdutoService> implements IProdutoController {

    private final ProdutoService produtoService;

    @Override
    public ResponseEntity<ProdutoDTO> incluir(Produto produto) {
        return ResponseEntity.ok(convert(produtoService.incluir(produto), ProdutoDTO.class));
    }

    @Override
    public List<Produto> listar() {
        return produtoService.listAllDisponivel();
    }

    @Override
    public void editar(Integer id, ProdutoDTO produtoDTO) {
        Produto produto = convert(produtoDTO, Produto.class);
        produtoService.editar(id, produto);
    }

    @Override
    public ProdutoDTO findById(Integer id) {
        return convert(produtoService.findById(id), ProdutoDTO.class);
    }
}
