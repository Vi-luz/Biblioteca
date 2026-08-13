package com.uniamerica.biblioteca.controller;


import com.uniamerica.biblioteca.controller.dto.cliente.ClienteRequest;
import com.uniamerica.biblioteca.controller.dto.cliente.ClienteResponse;
import com.uniamerica.biblioteca.entity.ClienteEntity;
import com.uniamerica.biblioteca.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ClienteEntity cliente){
        try{
            ClienteEntity mensagem = this.clienteService.save(cliente);
            return new ResponseEntity<>(mensagem.toString(), HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }


    }
    //long id para saber o id que esta sendo alterado
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ClienteEntity cliente,@PathVariable long id){
        try{
            ClienteEntity mensagem = this.clienteService.update(cliente,id);
            return new ResponseEntity<>(mensagem.toString(), HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            //aqui em delete nao temos o objeto na service entao mandamos apenas o id
            ClienteEntity mensagem = this.clienteService.delete(id);
            return new ResponseEntity<>(mensagem.toString(), HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List><ClienteEntity> findAll(){
        try{
            //aqui em delete nao temos o objeto na service entao mandamos apenas o id
            List<com.uniamerica.biblioteca.entity.ClienteEntity> lista  = this.clienteService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/findByid/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable long id){
        try{

        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
