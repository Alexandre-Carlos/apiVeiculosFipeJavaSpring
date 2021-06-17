package com.zupproject.desafio.interfaces.usecases.veiculo;


import com.zupproject.desafio.dto.veiculo.RetornarVeiculoIdResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IRetornarVeiculoIdUseCases {

    RetornarVeiculoIdResponseDTO Executar(int id);

}
