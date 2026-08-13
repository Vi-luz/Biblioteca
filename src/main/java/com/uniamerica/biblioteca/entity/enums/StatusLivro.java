package com.uniamerica.biblioteca.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusLivro {

    DISPONIVEL("Disponível"),
    EMPRESTADO("Emprestado"),
    RESERVADO("Reservado"),
    EM_MANUTENCAO("Em Manutenção"),
    PERDIDO("Perdido");

    private final String descricao;
}