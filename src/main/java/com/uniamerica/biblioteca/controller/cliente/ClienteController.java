package com.uniamerica.biblioteca.controller.cliente;


import com.uniamerica.biblioteca.entity.ClienteEntity;
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
    public ResponseEntity<String> save(@RequestBody ClienteEntity cliente){
        try{
            String mensagem = this.clienteService.save(cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }


    }
    //long id para saber o id que esta sendo alterado
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody ClienteEntity cliente,@PathVariable long id){
        try{
            String mensagem = this.clienteService.update(cliente,id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            //aqui em delete nao temos o objeto na service entao mandamos apenas o id
            String mensagem = this.clienteService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping()
    public ResponseEntity<List<ClienteEntity>> findAll(){
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
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
