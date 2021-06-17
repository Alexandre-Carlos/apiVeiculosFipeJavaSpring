package com.zupproject.desafio.interfaces.usecases.veiculo;

import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAdicionarVeiculoUseCases {

    AdicionarVeiculoResponseDTO Executar(AdicionarVeiculoRequestDTO request);

}
