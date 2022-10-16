package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
