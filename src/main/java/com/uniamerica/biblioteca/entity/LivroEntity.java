package com.uniamerica.biblioteca.entity;


import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.entity.enums.Idioma;
import com.uniamerica.biblioteca.entity.enums.StatusLivro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String autor;
    private String editora;

    @ElementCollection(targetClass = Genero.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "livro_genero", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "genero")
    private List<Genero> genero;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    private Integer anoPublicacao;

    private Integer quantidadeTotal;
    private Integer quantidadeDisponivel;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;
}
