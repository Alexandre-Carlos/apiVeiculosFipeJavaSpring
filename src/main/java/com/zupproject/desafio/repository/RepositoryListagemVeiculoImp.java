package com.zupproject.desafio.repository;

import com.zupproject.desafio.interfaces.repository.listagem.IRepositoryListagemVeiculoImp;
import com.zupproject.desafio.interfaces.repository.veiculo.IRepositoryVeiculoImp;
import com.zupproject.desafio.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RepositoryListagemVeiculoImp implements IRepositoryListagemVeiculoImp {

    @Autowired
    private IRepositoryVeiculoImp repository;

    @Transactional(readOnly = true)
    public  List<Veiculo> findByIdusuario(int idUsuario){
        List<Veiculo> veiculos =  repository.findByIdusuario(idUsuario);
        return veiculos;
    }

}
