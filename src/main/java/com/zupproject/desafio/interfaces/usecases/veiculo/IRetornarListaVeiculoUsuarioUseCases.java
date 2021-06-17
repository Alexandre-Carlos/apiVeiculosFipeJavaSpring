package com.zupproject.desafio.interfaces.usecases.veiculo;

import com.zupproject.desafio.dto.veiculo.RetornarListaVeiculoUsuarioResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IRetornarListaVeiculoUsuarioUseCases {

    RetornarListaVeiculoUsuarioResponseDTO Executar(int id);

}
