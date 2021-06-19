package com.zupproject.desafio.dto.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AdicionarUsuarioRequestDTO {

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String cpf;
    @NotNull
    private LocalDate datanascimento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }
}
