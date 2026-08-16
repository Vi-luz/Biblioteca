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
import org.springframework.web.server.ResponseStatusException;

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
        }catch (ResponseStatusException e){
            throw e;
        }
        catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
    //long id para saber o id que esta sendo alterado
    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteResponse> update(@RequestBody ClienteRequest clienteRequest,@PathVariable long id){
        try{
            ClienteEntity cliente = this.clienteService.atualizar(id, clienteRequest);
            return new ResponseEntity<>(ClienteResponse.de(cliente), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            this.clienteService.deletarPorId(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (ResponseStatusException e){
            throw e;
        } catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
        }catch (ResponseStatusException e){
            throw e;
        }catch(Exception ex){
            //catch aonde retorna algum erro generico pro usuario
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByid/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable long id){
        try{
            ClienteEntity cliente = this.clienteService.buscarPorId(id);

            return new ResponseEntity<>(ClienteResponse.de(cliente), HttpStatus.OK);
        }catch (ResponseStatusException e){
            throw e;
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
