package com.will.gerenciadormontagem.controller;

import com.will.gerenciadormontagem.controller.interfaces.IPromocaoController;
import com.will.gerenciadormontagem.model.dto.PromocaoDTO;
import com.will.gerenciadormontagem.model.entity.Promocao;
import com.will.gerenciadormontagem.service.PromocaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PromocaoController extends AbstractController<PromocaoService> implements IPromocaoController {
    @Override
    public PromocaoDTO incluir(PromocaoDTO promocaoDTO) {
        return convert(getService().incluir(convert(promocaoDTO, Promocao.class)), PromocaoDTO.class);
    }

    @Override
    public List<PromocaoDTO> listarPorProduto(Integer idProduto) {
        return null;
    }

    @Override
    public PromocaoDTO buscarPromocao(Integer id) {
        return null;
    }

    @Override
    public List<PromocaoDTO> listAll() {
        return null;
    }

    @Override
    public void editar(Integer id, PromocaoDTO promocaoDTO) {

    }
}
