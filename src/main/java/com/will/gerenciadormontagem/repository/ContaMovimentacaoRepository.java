package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.ContaMovimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaMovimentacaoRepository extends JpaRepository<ContaMovimento, Integer> {
}
