package com.zupproject.desafio.usecases.veiculo;


import com.zupproject.desafio.adapter.veiculo.AtualizarVeiculoAdapter;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.veiculo.IAtualizarVeiculoUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import com.zupproject.desafio.validator.veiculo.AtualizarVeiculoRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarVeiculoUseCase implements IAtualizarVeiculoUseCases {

    @Autowired
    private RepositoryVeiculoImp repository;

    @Autowired
    private RepositoryUsuarioImp repositoryUsuario;

    @Autowired
    private AtualizarVeiculoAdapter adapter;

    @Override
    public AtualizarVeiculoResponseDTO Executar(AtualizarVeiculoRequestDTO request, int id) {

        AtualizarVeiculoResponseDTO response = new AtualizarVeiculoResponseDTO();

        List<String> erros = new ArrayList<String>();

        try{
            Veiculo verificaVeiculoCadastrado = repository.findById(id);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

        Usuario verificaUsuarioCadastrado = repositoryUsuario.findById(request.getIdusuario());

        if (verificaUsuarioCadastrado == null){
//            erros.add("Email e Cpf são requeridos e devem ser únicos!");
//            response.setMensagem(erros);
//            return response;

            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }


        AtualizarVeiculoRequestValidator validacao = new AtualizarVeiculoRequestValidator();

        try {

            response = validacao.ValidarCamposAtualizarVeiculo(request);

            if(response.getMensagem().size() > 0){
                //response.setMensagem(response.getMensagem());
                throw new BusinessException(MessageUtil.CAMPOS_INVALIDOS);
                //return response;
            }


            Veiculo veiculoAtualizar = adapter.converterRequestParaVeiculo(request);
            veiculoAtualizar.setId(id);
            veiculoAtualizar.setValortabelafipe(10500D);

            repository.save(veiculoAtualizar);

            response = adapter.converterVeiculoParaResponse(veiculoAtualizar);

            return response;

        } catch(Exception ex) {
//            erros.add("Erro ao adicionar o Veículo!");
//            response.setMensagem(erros);
//            return response;
            throw new BusinessException(MessageUtil.USUARIO_INVALIDO);
        }
    }
}
