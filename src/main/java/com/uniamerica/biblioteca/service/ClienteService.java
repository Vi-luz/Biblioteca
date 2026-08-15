package com.uniamerica.biblioteca.service;

import com.uniamerica.biblioteca.entity.ClienteEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClienteService {

    public String save(ClienteEntity cliente){
        //implementar dps
        return "Cliente salvo com sucesso!";

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
    public List<ClienteEntity> listar(){return this.findAll();}
    public ClienteEntity findById(long id){
        //implementar dps
        return null;
    }

}
