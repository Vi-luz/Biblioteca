package com.uniamerica.biblioteca.controller;

import com.uniamerica.biblioteca.entity.Usuarios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @PostMapping
    public ResponseEntity<Usuarios> criarUsuarios(@RequestBody CriarUsuarios criarUsuariosDto){
        return null;
    }
}
