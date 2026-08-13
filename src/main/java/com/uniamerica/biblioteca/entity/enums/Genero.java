package com.uniamerica.biblioteca.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Genero {

    FICCAO_CIENTIFICA("Ficção Científica"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    TERROR("Terror"),
    SUSPENSE("Suspense"),
    BIOGRAFIA("Biografia"),
    HISTORIA("História"),
    INFANTIL("Infantil"),
    JUVENIL("Juvenil"),
    TECNICO("Técnico"),
    AUTOAJUDA("Autoajuda"),
    POESIA("Poesia"),
    DRAMA("Drama"),
    HUMOR("Humor");

    private final String descricao;
}