package com.zupproject.desafio.interfaces.repository.usuario;

import com.zupproject.desafio.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IRepositoryUsuarioImp {

   int save(Usuario request);

   int update(Usuario request);

   void delete(int id);

   List<Usuario> findAll();

   Usuario findById(int id);

   Boolean findByEmailAndCpf(String email, String cpf);

}
