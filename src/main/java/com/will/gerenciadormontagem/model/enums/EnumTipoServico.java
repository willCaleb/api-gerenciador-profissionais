package com.will.gerenciadormontagem.model.enums;

public enum EnumTipoServico {
    CONSTRUCAO("Construção"),
    MANUTENCAO("Manutenção"),
    VENDA("Venda");

    private final String descricao;
    EnumTipoServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
