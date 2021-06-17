package com.zupproject.desafio.usecases.usuario;


import com.zupproject.desafio.adapter.usuario.AtualizaUsuarioAdapter;
import com.zupproject.desafio.dto.usuario.AtualizarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AtualizarUsuarioResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.usuario.IAtualizarUsuarioUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.util.MessageUtil;

import com.zupproject.desafio.validator.usuario.AtualizarUsuarioRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarUsuarioUseCase implements IAtualizarUsuarioUseCases {

    @Autowired
    private RepositoryUsuarioImp repository;

    @Autowired
    private AtualizaUsuarioAdapter adapter;

    @Override
    public AtualizarUsuarioResponseDTO Executar(AtualizarUsuarioRequestDTO request, int id) {

        AtualizarUsuarioResponseDTO response = new AtualizarUsuarioResponseDTO();

        List<String> erros = new ArrayList<String>();

        try{
            Usuario verificaUsuarioCadastrado = repository.findById(id);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }


        AtualizarUsuarioRequestValidator validacao = new AtualizarUsuarioRequestValidator();

        try {

            response = validacao.ValidarCamposAtualizarUsuario(request);

            if(response.getMensagem().size() > 0){
                //response.setMensagem(response.getMensagem());
                throw new BusinessException(MessageUtil.CAMPOS_INVALIDOS);
                //return response;
            }


            Usuario usuarioAtualizar = adapter.converterRequestParaUsuario(request);
            usuarioAtualizar.setId(id);

            repository.save(usuarioAtualizar);

            response = adapter.converterUsuarioParaResponse(usuarioAtualizar);

            return response;

        } catch(Exception ex) {
//            erros.add("Erro ao adicionar o  Usuário!");
//            response.setMensagem(erros);
//            return response;
            throw new BusinessException(MessageUtil.USUARIO_INVALIDO);
        }
    }
}
