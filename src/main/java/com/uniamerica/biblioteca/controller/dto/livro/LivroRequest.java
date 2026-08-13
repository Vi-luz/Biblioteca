package com.uniamerica.biblioteca.controller.dto.livro;

import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.entity.enums.Idioma;

import java.util.List;

public record LivroRequest(
        String titulo,
        String autor,
        String aditora,
        List<Genero> genero,
        Idioma idioma,
        Integer anoPublicacao,
        Integer quantidadeTotal
) {

}
