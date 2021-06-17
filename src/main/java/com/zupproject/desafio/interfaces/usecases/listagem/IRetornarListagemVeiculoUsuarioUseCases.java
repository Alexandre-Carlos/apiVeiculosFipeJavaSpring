package com.zupproject.desafio.interfaces.usecases.listagem;

import com.zupproject.desafio.dto.listagem.RetornarListagemVeiculoUsuarioResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRetornarListagemVeiculoUsuarioUseCases {

    List<RetornarListagemVeiculoUsuarioResponseDTO> Executar(int id);

}
