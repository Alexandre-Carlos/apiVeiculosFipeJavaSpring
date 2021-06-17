package com.zupproject.desafio.controller;

import com.zupproject.desafio.dto.veiculo.*;
import com.zupproject.desafio.interfaces.usecases.veiculo.*;
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
@RequestMapping(value = "/veiculo")
@Tag(name="Cadastro de Veículos")
public class VeiculoController {

    @Autowired
    public IAdicionarVeiculoUseCases adicionarVeiculoUseCase;

    @Autowired
    public IAtualizarVeiculoUseCases atualizarVeiculoUseCase;

    @Autowired
    public IDeletarVeiculoUseCases deletarVeiculoUseCase;

    @Autowired
    public IRetornarListaVeiculoUseCases retornarListaVeiculoUseCases;

    @Autowired
    public IRetornarVeiculoIdUseCases retornarVeiculoIdUseCases;

    @Autowired
    public IRetornarListaVeiculoUsuarioUseCases retornarListaVeiculoUsuarioUseCases;

    @Operation(summary = "Adicionar Veículo")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdicionarVeiculoResponseDTO> save(@Valid @RequestBody AdicionarVeiculoRequestDTO request){
        return new ResponseEntity<>(adicionarVeiculoUseCase.Executar(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Alterar Veículo")
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AtualizarVeiculoResponseDTO> update(@PathVariable(value = "id") int id, @Valid @RequestBody AtualizarVeiculoRequestDTO request){
        return new ResponseEntity<>(atualizarVeiculoUseCase.Executar(request, id), HttpStatus.OK);
    }

    @Operation(summary = "Listar Veiculos")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RetornarListaVeiculoResponseDTO>> findAll(){
        return  new ResponseEntity(retornarListaVeiculoUseCases.Executar(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna o Veículo por Id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RetornarVeiculoIdResponseDTO> findById(@PathVariable int id){
        return new ResponseEntity<>(retornarVeiculoIdUseCases.Executar(id), HttpStatus.OK);
    }

    @Operation(summary = "Excluir Veículo")
    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeletarVeiculoResponseDTO> delete(@PathVariable int id){
        return new ResponseEntity(deletarVeiculoUseCase.Executar(id), HttpStatus.OK);
    }

    @Operation(summary = "Listar Veiculos de um Usuário")
    @GetMapping(value = "/usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RetornarListaVeiculoResponseDTO>> findAllCars(@PathVariable(value = "id") int id){
        return  new ResponseEntity(retornarListaVeiculoUsuarioUseCases.Executar(id), HttpStatus.OK);
    }


}
