package com.zupproject.desafio.repository;


import com.zupproject.desafio.interfaces.repository.usuario.IRepositoryUsuario;
import com.zupproject.desafio.interfaces.repository.usuario.IRepositoryUsuarioImp;
import com.zupproject.desafio.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryUsuarioImp implements IRepositoryUsuarioImp {

    @Autowired
    private IRepositoryUsuario repository;

    @Transactional
    public int save(Usuario request){
        repository.save(request);
        return request.getId();
    }

    @Transactional
    public int update(Usuario request){
        repository.save(request);
        return request.getId();
    }

    @Transactional
    public void delete(int id){
        Usuario usuario = this.findById(id);
        repository.deleteById(usuario.getId());
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        List<Usuario> ListaUsuarios = repository.findAll();
        return ListaUsuarios;
    }

    @Transactional(readOnly = true)
    public Usuario findById(int id){
        Usuario usuario = repository.findById(id).get();
        return usuario;
    }

    public Boolean findByEmailAndCpf(String email, String cpf) {
        Optional<Usuario> optionalUsuario = repository.findByEmailAndCpf(email, cpf);
        if(optionalUsuario.isPresent()){
            return true;
            //throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        return false;


    }
}
