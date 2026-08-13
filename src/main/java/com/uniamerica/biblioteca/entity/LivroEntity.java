package com.uniamerica.biblioteca.entity;


import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.entity.enums.Idioma;
import com.uniamerica.biblioteca.entity.enums.StatusLivro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivroEntity {

    private long id;

    private String titulo;
    private String autor;
    private String editora;
    private List<Genero> genero;
    private Idioma idioma;
    private Integer anoPublicacao;

    private Integer quantidadeTotal;
    private Integer quantidadeDisponivel;
    private StatusLivro status;
}
