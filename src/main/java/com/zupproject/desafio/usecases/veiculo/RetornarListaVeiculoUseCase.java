package com.zupproject.desafio.usecases.veiculo;

import com.zupproject.desafio.dto.veiculo.RetornarListaVeiculoResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.veiculo.IRetornarListaVeiculoUseCases;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetornarListaVeiculoUseCase implements IRetornarListaVeiculoUseCases {

    @Autowired
    private RepositoryVeiculoImp repository;

    @Override
    public RetornarListaVeiculoResponseDTO Executar() {

        RetornarListaVeiculoResponseDTO response = new RetornarListaVeiculoResponseDTO();

        try{
            List<Veiculo> listaVeiculo = repository.findAll();
            response.setVeiculos(listaVeiculo);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

        return response;
    }
}
