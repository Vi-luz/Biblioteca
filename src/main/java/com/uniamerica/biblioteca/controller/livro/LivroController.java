package com.uniamerica.biblioteca.controller.livro;

import com.uniamerica.biblioteca.controller.livro.dto.LivroRequest;
import com.uniamerica.biblioteca.controller.livro.dto.LivroResponse;
import com.uniamerica.biblioteca.entity.LivroEntity;
import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping("/create")
    public ResponseEntity<LivroResponse> create (@RequestBody LivroRequest  livroRequest){

        try {
            LivroEntity livroEntity = this.livroService.create(livroRequest);
            return new ResponseEntity<>(LivroResponse.de(livroEntity), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> buscarPorId (@PathVariable Long id){

        try {
            LivroEntity livroEntity = this.livroService.buscarPorId(id);
            return new ResponseEntity<LivroResponse>(LivroResponse.de(livroEntity), HttpStatus.OK);
        } catch (ResponseStatusException responseStatusException) {
            throw responseStatusException;
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<LivroResponse>> listar(){
        try {
            List<LivroResponse> livros = this.livroService.listar()
                    .stream()
                    .map(LivroResponse::de)
                    .toList();
            return new ResponseEntity<>(livros, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<LivroResponse>> buscarPorGenero(@RequestParam Genero genero) {
        try {
            List<LivroResponse> livros = this.livroService.buscarPorGenero(genero)
                    .stream()
                    .map(LivroResponse::de)
                    .toList();
            return new ResponseEntity<>(livros, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> atualizar(@PathVariable Long id,
                                                   @RequestBody LivroRequest livroRequest)
    {
        try {
            LivroEntity livroEntity = this.livroService.atualizar(id, livroRequest);
            return new ResponseEntity<LivroResponse>
                    (LivroResponse.de(livroEntity), HttpStatus.OK);
        } catch (ResponseStatusException responseStatusException){
            throw responseStatusException;
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroResponse> delete (@PathVariable Long id){

        try {
            this.livroService.deletar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResponseStatusException responseStatusException){
            throw responseStatusException;
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

}
