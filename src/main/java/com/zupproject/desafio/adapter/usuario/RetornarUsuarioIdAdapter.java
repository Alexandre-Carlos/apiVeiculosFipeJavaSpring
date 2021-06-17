package com.zupproject.desafio.adapter.usuario;

import com.zupproject.desafio.dto.usuario.RetornarUsuarioIdResponseDTO;
import com.zupproject.desafio.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class RetornarUsuarioIdAdapter {

    public RetornarUsuarioIdResponseDTO converterUsuarioParaResponse(Usuario request){
        RetornarUsuarioIdResponseDTO response = new RetornarUsuarioIdResponseDTO();

        response.setId(request.getId());
        response.setNome(request.getNome());
        response.setCpf(request.getCpf());
        response.setEmail(request.getEmail());
        response.setDatanascimento(request.getDatanascimento());

        return response;
    }

    public Usuario converterResponseParaUsuario(RetornarUsuarioIdResponseDTO request){
        Usuario usuario = new Usuario();

        usuario.setId(request.getId());
        usuario.setNome(request.getNome());
        usuario.setCpf(request.getCpf());
        usuario.setEmail(request.getEmail());
        usuario.setDatanascimento(request.getDatanascimento());

        return usuario;
    }

}
