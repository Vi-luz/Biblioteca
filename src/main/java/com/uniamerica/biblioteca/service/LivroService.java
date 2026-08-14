package com.uniamerica.biblioteca.service;

import com.uniamerica.biblioteca.controller.livro.dto.LivroRequest;
import com.uniamerica.biblioteca.entity.LivroEntity;
import com.uniamerica.biblioteca.entity.enums.Genero;
import com.uniamerica.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    //Busca unica de um livro de acordo com o Id
    public LivroEntity buscarPorId(Long id){
        return this.livroRepository.findById(id)
                .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Livro não encontrado com id "+ id));

    }

    //Busca geral de todos os livros
    public List<LivroEntity> listar() {return this.livroRepository.findAll();}

    public List<LivroEntity> buscarPorGenero(Genero genero){
        return this.livroRepository.findAll()
                .stream()
                .filter(livroEntity -> livroEntity.getGenero() != null &&livroEntity.getGenero().contains(genero))
                .toList();
    }

    //Atualiza dade de um livro
    public LivroEntity atualizar(Long id, LivroRequest livroRequest){
        LivroEntity livroEntity = this.buscarPorId(id);

        livroEntity.setTitulo((livroRequest.titulo()));
        livroEntity.setAutor(livroRequest.autor());
        livroEntity.setEditora(livroRequest.editora());
        livroEntity.setGenero(livroRequest.genero());
        livroEntity.setIdioma(livroRequest.idioma());
        livroEntity.setAnoPublicacao(livroRequest.anoPublicacao());
        livroEntity.setQuantidadeTotal(livroRequest.quantidadeTotal());

        return this.livroRepository.save(livroEntity);
    }
}