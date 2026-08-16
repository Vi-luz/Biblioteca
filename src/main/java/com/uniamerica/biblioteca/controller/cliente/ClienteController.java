package com.uniamerica.biblioteca.controller.cliente;


import com.uniamerica.biblioteca.controller.cliente.dto.ClienteRequest;
import com.uniamerica.biblioteca.controller.cliente.dto.ClienteResponse;
import com.uniamerica.biblioteca.entity.ClienteEntity;
import com.uniamerica.biblioteca.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<ClienteResponse> save(@RequestBody ClienteRequest clienteRequest){
        try{
            ClienteEntity clienteEntity = this.clienteService.save(clienteRequest);
            return new ResponseEntity<ClienteResponse>(ClienteResponse.de(clienteEntity), HttpStatus.CREATED);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    public ResponseEntity<List<ClienteResponse>> listar(){
        try{
            List<ClienteResponse> clientes = this.clienteService.listar()
                    .stream()
                    .map(ClienteResponse::de)
                    .toList();
                    return new ResponseEntity<>(clientes, HttpStatus.OK);
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
