package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
}
