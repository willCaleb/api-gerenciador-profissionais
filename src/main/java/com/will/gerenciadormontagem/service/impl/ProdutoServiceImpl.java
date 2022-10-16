package com.will.gerenciadormontagem.service.impl;

import com.will.gerenciadormontagem.model.entity.Produto;
import com.will.gerenciadormontagem.model.entity.Promocao;
import com.will.gerenciadormontagem.repository.ProdutoRepository;
import com.will.gerenciadormontagem.service.ProdutoService;
import com.will.gerenciadormontagem.service.PromocaoService;
import com.will.gerenciadormontagem.utils.ListUtils;
import com.will.gerenciadormontagem.utils.ObjectUtils;
import com.will.gerenciadormontagem.utils.Utils;
import com.will.gerenciadormontagem.validator.Validator;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl extends AbstractServiceUtil implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    private final PromocaoService promocaoService;
    @Override
    public Produto incluir(Produto produto) {
        if(ListUtils.isNotNullOrEmpty(produto.getPromocoes())){
            produto.getPromocoes().forEach(Validator::validatePromocao);
        }
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listAllDisponivel() {
        return produtoRepository.findAllByDisponivelTrue();
    }

    @Override
    public void editar(Integer id, Produto produto) {
        Produto produtoManaged = validate(getRepository().findById(id));
        produtoManaged.setCodProduto(nvl(produto.getCodProduto(), produtoManaged.getCodProduto()));
        produtoManaged.setNome(nvl(produto.getNome(), produtoManaged.getNome()));
        produtoManaged.setPreco(nvl(produto.getPreco(), produtoManaged.getPreco()));
        produtoManaged.setDisponivel(nvl(produto.getDisponivel(), produtoManaged.getDisponivel()));

        getRepository().save(produtoManaged);
    }

    @Transactional
    public void executePromocao(Integer idProduto, Integer idPromocao){
        Produto produto = validate(getRepository().findById(idProduto));
        Promocao promocao = promocaoService.findById(idPromocao);

        if(Utils.isNotEmpty(promocao.getPorcentagem())){
            produto.setPreco(resolverPrecoPorcentagem(produto.getPreco(), promocao.getPorcentagem()));
        }
        if(Utils.isNotEmpty(promocao.getValor())){
            produto.setPreco(produto.getPreco().subtract(promocao.getValor()));
        }
        getRepository().save(produto);
    }

    private BigDecimal resolverPrecoPorcentagem(BigDecimal valor, BigDecimal porcentagem){
        return valor.subtract(valor.multiply(porcentagem.divide(BigDecimal.valueOf(100))));
    }

    @Override
    public Produto findById(Integer id) {
        return validate(getRepository().findById(id));
    }

    @Override
    public JpaRepository<Produto, Integer> getRepository() {
        return this.produtoRepository;
    }
}
