package com.uniamerica.biblioteca.controller.livro.dto;

import com.uniamerica.biblioteca.entity.LivroEntity;
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
    public static LivroResponse de(LivroEntity livroEntity){
        return new LivroResponse(
                livroEntity.getId(),
                livroEntity.getTitulo(),
                livroEntity.getAutor(),
                livroEntity.getEditora(),
                livroEntity.getGenero(),
                livroEntity.getIdioma(),
                livroEntity.getAnoPublicacao(),
                livroEntity.getQuantidadeDisponivel(),
                livroEntity.getStatus()
        );
    }
}
