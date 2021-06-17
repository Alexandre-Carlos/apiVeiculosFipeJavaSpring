package com.zupproject.desafio.controller;

import com.zupproject.desafio.dto.listagem.RetornarListagemVeiculoUsuarioResponseDTO;
import com.zupproject.desafio.interfaces.usecases.listagem.IRetornarListagemVeiculoUsuarioUseCases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Listagem")
@Tag(name="Listagem de Veículos de um Usuário")
public class ListagemController {

    @Autowired
    public IRetornarListagemVeiculoUsuarioUseCases retornarListagemVeiculoUsuarioUseCases;

    @Operation(summary = "Listagem dos Veiculos de um Usuário")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RetornarListagemVeiculoUsuarioResponseDTO>> findAllCars(@PathVariable(value = "id") int id){
        return  new ResponseEntity(retornarListagemVeiculoUsuarioUseCases.Executar(id), HttpStatus.OK);
    }

}
