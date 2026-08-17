package com.uniamerica.biblioteca.controller.cliente.dto;

import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.entity.enums.Idioma;
import com.uniamerica.biblioteca.entity.enums.StatusCliente;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ClienteRequest(

        @NotBlank(message = "Insira um nome (OBRIGATORIO)")
        String nome,

        @NotBlank(message = "Insira um cpf (OBRIGATORIO)")
        String cpf,

        @NotBlank(message = "Insira um Email (OBRIGATORIO)")
        String email,

        String telefone,

        @NotBlank(message = "Insira Data de nascimento é (OBRIGATORIO)")
        LocalDate dataNascimento,

        LocalDateTime dataCadastro,

        StatusCliente status


) {
}