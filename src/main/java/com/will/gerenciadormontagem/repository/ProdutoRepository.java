package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findAllByDisponivelTrue();
}
