package com.zupproject.desafio.interfaces.repository.usuario;

import com.zupproject.desafio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositoryUsuario extends JpaRepository<Usuario, Integer> {



    @Query(value = "SELECT u FROM Usuario u WHERE u.email LIKE ?1 OR u.cpf LIKE ?2")
    Optional<Usuario> findByEmailAndCpf(String email, String cpf);


}
