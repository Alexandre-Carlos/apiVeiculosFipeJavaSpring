package com.zupproject.desafio.interfaces.repository.veiculo;


import com.zupproject.desafio.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRepositoryVeiculoImp {

   int save(Veiculo request);


   int update(Veiculo request);

   void delete(int id);

   List<Veiculo> findAll();

   Veiculo findById(int id);

   List<Veiculo> findByIdusuario(int idUsuario);


}
