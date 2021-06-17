package com.zupproject.desafio.repository;

import com.zupproject.desafio.interfaces.repository.veiculo.IRepositoryVeiculo;
import com.zupproject.desafio.interfaces.repository.veiculo.IRepositoryVeiculoImp;

import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.model.Veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class RepositoryVeiculoImp implements IRepositoryVeiculoImp {

    @Autowired
    private IRepositoryVeiculo repository;

    @Transactional
    public int save(Veiculo request){
        repository.save(request);
        return request.getId();
    }

    @Transactional
    public int update(Veiculo request){
        repository.save(request);
        return request.getId();
    }

    @Transactional
    public void delete(int id){
        Veiculo veiculo = this.findById(id);
        repository.deleteById(veiculo.getId());
    }

    @Transactional(readOnly = true)
    public List<Veiculo> findAll() {
        List<Veiculo> ListaUsuarios = repository.findAll();
        return ListaUsuarios;
    }

    @Transactional(readOnly = true)
    public Veiculo findById(int id){
        Veiculo veiculo = repository.findById(id).get();
        return veiculo;
    }

    @Transactional(readOnly = true)
    public  List<Veiculo> findByIdusuario(int idUsuario){
        List<Veiculo> veiculos =  repository.findByIdusuario(idUsuario);
        return veiculos;
    }

}
