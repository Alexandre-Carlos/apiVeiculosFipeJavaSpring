package com.zupproject.desafio.usecases.veiculo;

import com.zupproject.desafio.adapter.usuario.RetornarUsuarioIdAdapter;
import com.zupproject.desafio.adapter.veiculo.RetornarVeiculoIdAdapter;
import com.zupproject.desafio.dto.usuario.RetornarUsuarioIdResponseDTO;
import com.zupproject.desafio.dto.veiculo.RetornarVeiculoIdResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.usuario.IRetornarUsuarioIdUseCases;
import com.zupproject.desafio.interfaces.usecases.veiculo.IRetornarVeiculoIdUseCases;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetornarVeiculoIdUseCase implements IRetornarVeiculoIdUseCases {

    @Autowired
    private RepositoryVeiculoImp repository;

    @Autowired
    private RetornarVeiculoIdAdapter adapter;

    @Override
    public RetornarVeiculoIdResponseDTO Executar(int id) {
        RetornarVeiculoIdResponseDTO response = new RetornarVeiculoIdResponseDTO();

        try{
            Veiculo veiculo = repository.findById(id);

            response = adapter.converterVeiculoParaResponse(veiculo);


        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }


            return response;


    }
}
