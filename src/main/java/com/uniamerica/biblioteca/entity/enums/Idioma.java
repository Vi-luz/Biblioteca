package com.uniamerica.biblioteca.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Idioma {

    PORTUGUES("Português"),
    INGLES("Inglês"),
    ESPANHOL("Espanhol"),
    FRANCES("Francês"),
    ALEMAO("Alemão"),
    ITALIANO("Italiano"),
    JAPONES("Japonês"),
    OUTRO("Outro");

    private final String descricao;
}