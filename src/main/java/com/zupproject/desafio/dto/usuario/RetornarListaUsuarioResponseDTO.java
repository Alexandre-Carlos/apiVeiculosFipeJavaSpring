package com.zupproject.desafio.dto.usuario;

import com.zupproject.desafio.model.Usuario;

import java.time.LocalDate;
import java.util.List;

public class RetornarListaUsuarioResponseDTO {

   public List<Usuario> usuarios;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
