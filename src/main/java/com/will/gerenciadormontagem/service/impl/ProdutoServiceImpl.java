package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Produto;
import com.will.gerenciadormontagem.repository.ProdutoRepository;
import com.will.gerenciadormontagem.service.ProdutoService;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;
    @Override
    public Produto incluir(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listAllDisponivel() {
        return produtoRepository.findAllByDisponivelTrue();
    }

    @Override
    public void editar(Integer id, Produto produto) {
        Produto produtoManaged = ObjectUtils.validate(produtoRepository.findById(id));

    }

    @Override
    public Produto findById(Integer id) {
        return ObjectUtils.validate(produtoRepository.findById(id));
    }

    @Override
    public JpaRepository<Produto, Integer> getRepository() {
        return null;
    }
}
