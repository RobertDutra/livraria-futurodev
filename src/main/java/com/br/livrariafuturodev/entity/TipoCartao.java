package com.br.livrariafuturodev.entity;

import lombok.Getter;

@Getter
public enum TipoCartao {
    DEBITO("Débito"),
    CREDITO("Crédito");

    private String tipoCartao;

    TipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
