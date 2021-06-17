package com.zupproject.desafio.usecases.usuario;

import com.zupproject.desafio.dto.usuario.DeletarUsuarioResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.usuario.IDeletarUsuarioUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.util.MessageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarUsuarioUseCase implements IDeletarUsuarioUseCases {

    @Autowired
    private RepositoryUsuarioImp repository;

     @Override
    public DeletarUsuarioResponseDTO Executar(int id) {

        DeletarUsuarioResponseDTO response = new DeletarUsuarioResponseDTO();

        try{
            Usuario verificaUsuarioCadastrado = repository.findById(id);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

            repository.delete(id);
            response.getId();
            return response;
    }
}
