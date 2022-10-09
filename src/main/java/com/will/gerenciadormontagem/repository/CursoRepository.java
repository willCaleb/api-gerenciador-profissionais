package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
