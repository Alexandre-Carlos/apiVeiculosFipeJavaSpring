package com.zupproject.desafio.usecases.veiculo;

import com.zupproject.desafio.dto.veiculo.RetornarListaVeiculoResponseDTO;
import com.zupproject.desafio.dto.veiculo.RetornarListaVeiculoUsuarioResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.veiculo.IRetornarListaVeiculoUseCases;
import com.zupproject.desafio.interfaces.usecases.veiculo.IRetornarListaVeiculoUsuarioUseCases;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetornarListaVeiculoUsuarioUseCase implements IRetornarListaVeiculoUsuarioUseCases {

    @Autowired
    private RepositoryVeiculoImp repository;

    @Override
    public RetornarListaVeiculoUsuarioResponseDTO Executar(int idUsuario) {

        RetornarListaVeiculoUsuarioResponseDTO response = new RetornarListaVeiculoUsuarioResponseDTO();

        try{
            List<Veiculo> listaVeiculo = repository.findByIdusuario(idUsuario);
            response.setVeiculos(listaVeiculo);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

        return response;
    }
}
