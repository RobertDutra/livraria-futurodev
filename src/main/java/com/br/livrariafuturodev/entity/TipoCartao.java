package com.br.livrariafuturodev.entity;

import lombok.Getter;

@Getter
public enum TipoCartao {
    DEBITO("D�bito"),
    CREDITO("Cr�dito");

    private String tipoCartao;

    TipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
