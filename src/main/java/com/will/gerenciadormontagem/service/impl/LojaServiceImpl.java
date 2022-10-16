package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Loja;
import com.will.gerenciadormontagem.repository.LojaRepository;
import com.will.gerenciadormontagem.service.LojaService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LojaServiceImpl extends AbstractServiceUtil implements LojaService {
    private final LojaRepository lojaRepository;
    @Override
    public Loja incluir(Loja loja) {
        return getRepository().save(loja);
    }

    @Override
    public void editar(Integer id, Loja loja) {
        Loja lojaManaged = validate(getRepository().findById(id));

        lojaManaged.setCnpj(nvl(loja.getCnpj(), lojaManaged.getCnpj()));
        lojaManaged.setNomeFantasia(nvl(loja.getNomeFantasia(), lojaManaged.getNomeFantasia()));
        lojaManaged.setRazaoSocial(nvl(loja.getRazaoSocial(), lojaManaged.getRazaoSocial()));
        lojaManaged.setProdutos(nvl(loja.getProdutos(), lojaManaged.getProdutos()));

        lojaRepository.save(lojaManaged);
    }

    @Override
    public List<Loja> findAllLoja() {
        return lojaRepository.findAll();
    }

    @Override
    public Loja findById(Integer id) {
        return validate(lojaRepository.findById(id));
    }

    @Override
    public JpaRepository<Loja, Integer> getRepository() {
        return this.lojaRepository;
    }
}
