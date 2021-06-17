package com.zupproject.desafio.interfaces.usecases.usuario;

import com.zupproject.desafio.dto.usuario.RetornarUsuarioIdResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IRetornarUsuarioIdUseCases {

    RetornarUsuarioIdResponseDTO Executar(int id);

}
