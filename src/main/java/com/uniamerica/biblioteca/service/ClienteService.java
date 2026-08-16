package com.uniamerica.biblioteca.service;

import com.uniamerica.biblioteca.controller.cliente.dto.ClienteRequest;
import com.uniamerica.biblioteca.entity.ClienteEntity;
import com.uniamerica.biblioteca.entity.enums.StatusCliente;
import com.uniamerica.biblioteca.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteEntity save(ClienteRequest clienteRequest){
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setNome(clienteRequest.nome());
        clienteEntity.setCpf(clienteRequest.cpf());
        clienteEntity.setEmail(clienteRequest.email());
        clienteEntity.setTelefone(clienteRequest.telefone());
        clienteEntity.setDataNascimento(clienteRequest.dataNascimento());
        clienteEntity.setDataCadastro(clienteRequest.dataCadastro());
        clienteEntity.setStatus(StatusCliente.ATIVO);

        return this.clienteRepository.save(clienteEntity);
    }

    //long id para saber o id que esta sendo alterado
    public String update(ClienteEntity cliente,long id){
        //implementar dps
        return "Cliente atualizado com sucesso!";
    }
    public String delete(long id){
        //implementar daqui a pouco
        return "Cliente deletado com sucesso!";
    }
    public List<ClienteEntity> listar(){return this.listar();}
    public ClienteEntity findById(long id){
        //implementar dps
        return null;
    }

}
