package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {
}
