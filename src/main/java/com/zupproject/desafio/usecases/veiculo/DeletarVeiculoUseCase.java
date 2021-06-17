package com.zupproject.desafio.usecases.veiculo;

import com.zupproject.desafio.dto.veiculo.DeletarVeiculoResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.veiculo.IDeletarVeiculoUseCases;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarVeiculoUseCase implements IDeletarVeiculoUseCases {

    @Autowired
    private RepositoryVeiculoImp repository;

     @Override
    public DeletarVeiculoResponseDTO Executar(int id) {

        DeletarVeiculoResponseDTO response = new DeletarVeiculoResponseDTO();

        try{
            Veiculo verificaVeiculoCadastrado = repository.findById(id);

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

            repository.delete(id);
            response.setId(id);
            return response;
    }
}
