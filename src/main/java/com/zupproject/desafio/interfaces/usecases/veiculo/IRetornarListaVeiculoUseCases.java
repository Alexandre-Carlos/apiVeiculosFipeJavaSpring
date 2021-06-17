package com.zupproject.desafio.interfaces.usecases.veiculo;


import com.zupproject.desafio.dto.veiculo.RetornarListaVeiculoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IRetornarListaVeiculoUseCases {

    RetornarListaVeiculoResponseDTO Executar();

}
