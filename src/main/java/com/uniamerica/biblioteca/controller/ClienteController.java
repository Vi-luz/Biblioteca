package com.uniamerica.biblioteca.controller;


import com.uniamerica.biblioteca.controller.dto.cliente.ClienteRequest;
import com.uniamerica.biblioteca.controller.dto.cliente.ClienteResponse;
import com.uniamerica.biblioteca.entity.ClienteEntity;
import com.uniamerica.biblioteca.repository.ClienteRepository;
import com.uniamerica.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<ClienteEntity> save(@RequestBody ClienteRequest clienteRequest){
        try{
            ClienteEntity cliente = this.clienteService.salvar(clienteRequest);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }


    }
    //long id para saber o id que esta sendo alterado
    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteEntity> update(@RequestBody ClienteRequest clienteRequest,@PathVariable long id){
        try{
            ClienteEntity cliente = this.clienteService.atualizar(id, clienteRequest);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            this.clienteService.deletarPorId(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ClienteEntity>> findAll(){
        try{
            //aqui em delete nao temos o objeto na service entao mandamos apenas o id
            List<ClienteEntity> lista  = this.clienteService.listar();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/findByid/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable long id){
        try{
            ClienteEntity cliente = this.clienteService.buscarPorId(id);

            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
