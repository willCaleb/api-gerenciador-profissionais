package com.will.gerenciadormontagem.repository;

import com.will.gerenciadormontagem.model.entity.Profissional;
import com.will.gerenciadormontagem.model.entity.Servico;
import com.will.gerenciadormontagem.model.enums.EnumTipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query("select s from Servico s where s.tipoServico = :tipo")
    List<Servico> findAllServicosTipo(@Param("tipo") EnumTipoServico tipo);;

}
