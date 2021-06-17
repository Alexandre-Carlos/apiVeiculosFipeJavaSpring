package com.zupproject.desafio.interfaces.usecases.veiculo;


import com.zupproject.desafio.dto.veiculo.DeletarVeiculoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IDeletarVeiculoUseCases {

    DeletarVeiculoResponseDTO Executar(int id);

}
