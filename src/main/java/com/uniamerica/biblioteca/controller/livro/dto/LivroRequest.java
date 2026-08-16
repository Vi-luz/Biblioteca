package com.uniamerica.biblioteca.controller.livro.dto;

import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.entity.enums.Idioma;
import jakarta.validation.constraints.*;

import java.util.List;

public record LivroRequest(

        @NotBlank(message = "Título é obrigatório")
        String titulo,

        @NotBlank(message = "Autor é obrigatório")
        String autor,

        @NotBlank(message = "Editora é obrigatória")
        String editora,

        @NotEmpty(message = "Informe ao menos um gênero")
        List<Genero> genero,

        @NotNull(message = "Idioma é obrigatório")
        Idioma idioma,

        @NotNull(message = "Ano de publicação é obrigatório")
        @Positive(message = "Ano de publicação deve ser um número positivo")
        Integer anoPublicacao,

        @NotNull(message = "Quantidade total é obrigatória")
        @Min(value = 1, message = "Quantidade total deve ser pelo menos 1")
        Integer quantidadeTotal
) {

}
