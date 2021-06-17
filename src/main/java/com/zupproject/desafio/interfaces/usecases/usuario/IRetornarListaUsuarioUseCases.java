package com.zupproject.desafio.interfaces.usecases.usuario;

import com.zupproject.desafio.dto.usuario.DeletarUsuarioResponseDTO;
import com.zupproject.desafio.dto.usuario.RetornarListaUsuarioResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IRetornarListaUsuarioUseCases {

    RetornarListaUsuarioResponseDTO Executar();

}
