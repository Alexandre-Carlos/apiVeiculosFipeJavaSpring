package com.zupproject.desafio.usecases.usuario;

import com.zupproject.desafio.adapter.usuario.RetornarUsuarioIdAdapter;
import com.zupproject.desafio.dto.usuario.RetornarUsuarioIdResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.usuario.IRetornarUsuarioIdUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetornarUsuarioIdUseCase implements IRetornarUsuarioIdUseCases {

    @Autowired
    private RepositoryUsuarioImp repository;

    @Autowired
    private RetornarUsuarioIdAdapter adapter;

    @Override
    public RetornarUsuarioIdResponseDTO Executar(int id) {
        RetornarUsuarioIdResponseDTO response = new RetornarUsuarioIdResponseDTO();

        try{
            Usuario usuario = repository.findById(id);

            response = adapter.converterUsuarioParaResponse(usuario);


        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }


            return response;


    }
}
