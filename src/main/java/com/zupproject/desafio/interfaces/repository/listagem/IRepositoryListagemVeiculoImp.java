package com.zupproject.desafio.interfaces.repository.listagem;


import com.zupproject.desafio.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRepositoryListagemVeiculoImp {

   List<Veiculo> findByIdusuario(int idUsuario);


}
