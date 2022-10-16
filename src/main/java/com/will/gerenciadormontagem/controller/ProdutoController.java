package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IProdutoController;
import com.will.gerenciadormontagem.model.dto.ProdutoDTO;
import com.will.gerenciadormontagem.model.entity.Produto;
import com.will.gerenciadormontagem.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProdutoController extends AbstractController<ProdutoService> implements IProdutoController {

    @Override
    @Transactional
    public ResponseEntity<ProdutoDTO> incluir(ProdutoDTO produtoDTO) {
        Produto produto = convert(produtoDTO, Produto.class);
        return ResponseEntity.ok(convert(getService().incluir(produto), ProdutoDTO.class));
    }

    @Override
    @Transactional
    public List<ProdutoDTO> listar() {

        return convert(getService().listAllDisponivel(), ProdutoDTO.class);
    }

    @Override
    public void editar(Integer id, ProdutoDTO produtoDTO) {
        Produto produto = convert(produtoDTO, Produto.class);
        getService().editar(id, produto);
    }

    @Override
    @Transactional
    public ProdutoDTO findById(Integer id) {
        return convert(getService().findById(id), ProdutoDTO.class);
    }

    @Override
    public void ativarPromocoes(Integer idProduto, Integer idPromocao) {
        System.out.println();
        getService().executePromocao(idProduto, idPromocao);
    }
}
