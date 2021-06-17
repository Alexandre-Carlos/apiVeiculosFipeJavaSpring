package com.zupproject.desafio.usecases.usuario;


import com.zupproject.desafio.adapter.usuario.AdicionaUsuarioAdapter;
import com.zupproject.desafio.dto.usuario.AdicionarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AdicionarUsuarioResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.usuario.IAdicionarUsuarioUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.util.MessageUtil;
import com.zupproject.desafio.validator.usuario.AdicionarUsuarioRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdicionarUsuarioUseCase implements IAdicionarUsuarioUseCases {

    @Autowired
    private RepositoryUsuarioImp repository;

    @Autowired
    private AdicionaUsuarioAdapter adapter;

    @Override
    public AdicionarUsuarioResponseDTO Executar(AdicionarUsuarioRequestDTO request) {

        AdicionarUsuarioResponseDTO response = new AdicionarUsuarioResponseDTO();

        List<String> erros = new ArrayList<String>();

        Boolean verificaUsuarioCadastrado = repository.findByEmailAndCpf(request.getEmail(), request.getCpf());

        if (verificaUsuarioCadastrado){
//            erros.add("Email e Cpf são requeridos e devem ser únicos!");
//            response.setMensagem(erros);
//            return response;

            throw new BusinessException(MessageUtil.USUARIO_DUPLICADO);
        }

        AdicionarUsuarioRequestValidator validacao = new AdicionarUsuarioRequestValidator();

        try {

            response = validacao.ValidarCamposAdicionarUsuario(request);

            if(response.getMensagem().size() > 0){
                //response.setMensagem(response.getMensagem());
                throw new BusinessException(MessageUtil.CAMPOS_INVALIDOS);
                //return response;
            }


            Usuario usuarioAdicionar = adapter.converterRequestParaUsuario(request);
            repository.save(usuarioAdicionar);

            response = adapter.converterUsuarioParaResponse(usuarioAdicionar);

            return response;

        } catch(Exception ex) {
//            erros.add("Erro ao adicionar o  Usuário!");
//            response.setMensagem(erros);
//            return response;
            throw new BusinessException(MessageUtil.USUARIO_INVALIDO);
        }

    }
}
