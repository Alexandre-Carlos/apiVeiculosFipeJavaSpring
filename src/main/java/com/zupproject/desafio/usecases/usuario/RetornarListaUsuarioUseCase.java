package com.zupproject.desafio.usecases.usuario;

import com.zupproject.desafio.dto.usuario.RetornarListaUsuarioResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.usuario.IRetornarListaUsuarioUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetornarListaUsuarioUseCase implements IRetornarListaUsuarioUseCases {

    @Autowired
    private RepositoryUsuarioImp repository;

    @Override
    public RetornarListaUsuarioResponseDTO Executar() {

        RetornarListaUsuarioResponseDTO response = new RetornarListaUsuarioResponseDTO();

        try{
            List<Usuario> listaUsuario = repository.findAll();
            response.setUsuarios(listaUsuario);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

        return response;
    }
}
