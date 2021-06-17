package com.zupproject.desafio.controller;

import com.zupproject.desafio.dto.usuario.*;


import com.zupproject.desafio.interfaces.usecases.usuario.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuario")
@Tag(name="Cadastro de Usuários")
public class UsuarioController {

    @Autowired
    public IAdicionarUsuarioUseCases adicionarUsuarioUseCase;

    @Autowired
    public IAtualizarUsuarioUseCases atualizarUsuarioUseCase;

    @Autowired
    public IDeletarUsuarioUseCases deletarUsuarioUseCase;

    @Autowired
    public IRetornarListaUsuarioUseCases retornarListaUsuarioUseCases;

    @Autowired
    public IRetornarUsuarioIdUseCases retornarUsuarioIdUseCases;

    @Operation(summary = "Adicionar Usuário")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdicionarUsuarioResponseDTO> save(@Valid @RequestBody AdicionarUsuarioRequestDTO request){
        return new ResponseEntity<>(adicionarUsuarioUseCase.Executar(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Alterar Usuário")
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AtualizarUsuarioResponseDTO> update(@PathVariable(value = "id") int id, @Valid @RequestBody AtualizarUsuarioRequestDTO request){
        return new ResponseEntity<>(atualizarUsuarioUseCase.Executar(request, id), HttpStatus.OK);
    }

    @Operation(summary = "Listar Usuários")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RetornarListaUsuarioResponseDTO>> findAll(){
        return  new ResponseEntity(retornarListaUsuarioUseCases.Executar(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna o Usuário por Id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornarUsuarioIdResponseDTO> findById(@PathVariable int id){
        return new ResponseEntity<>(retornarUsuarioIdUseCases.Executar(id), HttpStatus.OK);
    }

    @Operation(summary = "Excluir Usuário")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeletarUsuarioResponseDTO> delete(@PathVariable int id){
        return new ResponseEntity(deletarUsuarioUseCase.Executar(id), HttpStatus.OK);
    }
}
