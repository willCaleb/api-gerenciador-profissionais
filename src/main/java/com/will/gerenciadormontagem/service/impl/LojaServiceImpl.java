package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Loja;
import com.will.gerenciadormontagem.repository.LojaRepository;
import com.will.gerenciadormontagem.service.LojaService;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import com.will.gerenciadormontagem.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LojaServiceImpl implements LojaService {
    private final LojaRepository lojaRepository;
    @Override
    public Loja incluir(Loja loja) {
        return getRepository().save(loja);
    }

    @Override
    public void editar(Integer id, Loja loja) {
        Loja lojaManaged = ObjectUtils.validate(getRepository().findById(id));
        lojaManaged.setCnpj(Utils.nvl(loja.getCnpj(), lojaManaged.getCnpj()));
        lojaManaged.setNomeFantasia(Utils.nvl(loja.getNomeFantasia(), lojaManaged.getNomeFantasia()));
        lojaManaged.setRazaoSocial(Utils.nvl(loja.getRazaoSocial(), lojaManaged.getRazaoSocial()));
        lojaManaged.setProdutos(Utils.nvl(loja.getProdutos(), lojaManaged.getProdutos()));

        lojaRepository.save(lojaManaged);
    }

    @Override
    public List<Loja> findAllLoja() {
        return lojaRepository.findAll();
    }

    @Override
    public JpaRepository<Loja, Integer> getRepository() {
        return this.lojaRepository;
    }
}
