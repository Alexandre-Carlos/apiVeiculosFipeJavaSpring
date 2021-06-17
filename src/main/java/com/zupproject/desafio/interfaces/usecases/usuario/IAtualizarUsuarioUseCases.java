package com.zupproject.desafio.interfaces.usecases.usuario;

import com.zupproject.desafio.dto.usuario.AtualizarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AtualizarUsuarioResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAtualizarUsuarioUseCases {

    AtualizarUsuarioResponseDTO Executar(AtualizarUsuarioRequestDTO request, int id);

}
