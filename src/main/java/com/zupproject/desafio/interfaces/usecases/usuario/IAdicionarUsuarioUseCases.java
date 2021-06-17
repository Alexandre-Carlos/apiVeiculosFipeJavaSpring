package com.zupproject.desafio.interfaces.usecases.usuario;

import com.zupproject.desafio.dto.usuario.AdicionarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AdicionarUsuarioResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAdicionarUsuarioUseCases {

    AdicionarUsuarioResponseDTO Executar(AdicionarUsuarioRequestDTO request);

}
