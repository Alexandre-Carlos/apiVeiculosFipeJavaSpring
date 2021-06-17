package com.zupproject.desafio.dto.usuario;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class AtualizarUsuarioResponseDTO {

    private int id;

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String cpf;


    @NotNull
    private LocalDate datanascimento;

    private List<String> mensagem;

    public List<String> getMensagem() {
        return mensagem;
    }

    public void setMensagem(List<String> mensagem) {
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
