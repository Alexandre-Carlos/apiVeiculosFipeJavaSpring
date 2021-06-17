package com.zupproject.desafio.interfaces.repository.veiculo;

import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IRepositoryVeiculo extends JpaRepository<Veiculo, Integer> {
    @Query("SELECT v FROM Veiculo v WHERE v.idusuario = ?1")
    List<Veiculo> findByIdusuario(int idUsuario);
}
