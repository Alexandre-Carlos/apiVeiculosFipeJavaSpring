package com.zupproject.desafio.model;

import java.util.List;

public class ModeloVeiculo {

    private List<Modelo> modelos;

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }


    public class Modelo
    {
        public Modelo(String codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        private String codigo ;
        private String nome;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }


    }

    public class Ano
    {
        public Ano(String nome, String codigo) {
            this.nome = nome;
            this.codigo = codigo;
        }

        private String nome;
        private String codigo;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
    }
}
