package com.uniamerica.biblioteca.controller.cliente.dto;

import com.uniamerica.biblioteca.entity.ClienteEntity;
import com.uniamerica.biblioteca.entity.enums.StatusCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClienteResponse(

        long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        LocalDate dataNascimento,
        LocalDateTime dataCadastro,
        StatusCliente status
) {
    public static ClienteResponse de(ClienteEntity clienteEntity){
        return new ClienteResponse(
        clienteEntity.getId(),
        clienteEntity.getNome(),
        clienteEntity.getCpf(),
        clienteEntity.getEmail(),
        clienteEntity.getTelefone(),
        clienteEntity.getDataNascimento(),
        clienteEntity.getDataCadastro(),
        clienteEntity.getStatus()
        );
    }
}