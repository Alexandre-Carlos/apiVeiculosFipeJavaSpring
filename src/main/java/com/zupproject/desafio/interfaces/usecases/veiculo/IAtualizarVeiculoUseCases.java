package com.zupproject.desafio.interfaces.usecases.veiculo;


import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAtualizarVeiculoUseCases {

    AtualizarVeiculoResponseDTO Executar(AtualizarVeiculoRequestDTO request, int id);

}
