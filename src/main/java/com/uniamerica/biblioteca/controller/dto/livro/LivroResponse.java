package com.uniamerica.biblioteca.controller.dto.livro;

import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.entity.enums.Idioma;
import com.uniamerica.biblioteca.entity.enums.StatusLivro;

import java.util.List;

public record LivroResponse(
        long id,
        String titulo,
        String autor,
        String editora,
        List<Genero> genero,
        Idioma idioma,
        Integer anoPublicacao,
        Integer quantidadeDisponivel,
        StatusLivro status
) {
}
