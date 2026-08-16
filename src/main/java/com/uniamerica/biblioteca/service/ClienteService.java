package com.uniamerica.biblioteca.service;

import com.uniamerica.biblioteca.controller.dto.cliente.ClienteRequest;
import com.uniamerica.biblioteca.entity.ClienteEntity;
import com.uniamerica.biblioteca.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteEntity salvar(ClienteRequest clienteRequest){
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome(clienteRequest.nome());
        cliente.setCpf(clienteRequest.cpf());
        cliente.setEmail(clienteRequest.email());
        cliente.setTelefone(clienteRequest.telefone());
        cliente.setDataNascimento(clienteRequest.dataNascimento());
        cliente.setDataCadastro(clienteRequest.dataCadastro());
        cliente.setStatus(clienteRequest.status());

        return this.clienteRepository.save(cliente);
    }


    public ClienteEntity buscarPorId(Long id){
        return this.clienteRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Carro não encontrado com id "+ id));
    }

    public ClienteEntity atualizar(Long id, ClienteRequest clienteRequest){
        ClienteEntity cliente = this.buscarPorId(id);

        cliente.setNome(clienteRequest.nome());
        cliente.setCpf(clienteRequest.cpf());
        cliente.setEmail(clienteRequest.email());
        cliente.setTelefone(clienteRequest.telefone());
        cliente.setDataNascimento(clienteRequest.dataNascimento());
        cliente.setDataCadastro(clienteRequest.dataCadastro());
        cliente.setStatus(clienteRequest.status());

        return this.clienteRepository.save(cliente);
    }

    public ClienteEntity atualizarParcial(Long id, ClienteRequest clienteRequest){
        ClienteEntity cliente = this.buscarPorId(id);

        if(clienteRequest.nome() != null) cliente.setNome(clienteRequest.nome());
        if(clienteRequest.cpf() != null) cliente.setCpf(clienteRequest.cpf());
        if(clienteRequest.email() != null) cliente.setEmail(clienteRequest.email());
        if(clienteRequest.telefone() != null) cliente.setTelefone(clienteRequest.telefone());
        if(clienteRequest.dataNascimento() != null) cliente.setDataNascimento(clienteRequest.dataNascimento());
        if(clienteRequest.dataCadastro() != null) cliente.setDataCadastro(clienteRequest.dataCadastro());
        if(clienteRequest.status() != null) cliente.setStatus(clienteRequest.status());

        return this.clienteRepository.save(cliente);
    }



    public List<ClienteEntity> listar(){
        return this.clienteRepository.findAll();
    }



    public void deletarPorId(Long id){
        ClienteEntity cliente = this.buscarPorId(id);
        this.clienteRepository.delete(cliente);
    }
}