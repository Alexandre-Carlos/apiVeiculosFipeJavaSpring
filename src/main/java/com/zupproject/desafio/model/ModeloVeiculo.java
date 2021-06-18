package com.zupproject.desafio.model;

import java.util.ArrayList;
import java.util.List;

public class ModeloVeiculo {

    public ModeloVeiculo() {

    }

    public ModeloVeiculo(List<Modelo> modelos, List<Ano> anos) {
        this.modelos = modelos;
        this.anos = anos;
    }

    private List<Modelo> modelos = new ArrayList<>();
    private List<Ano> anos = new ArrayList<>();

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public List<Ano> getAnos() {
        return anos;
    }

    public void setAnos(List<Ano> anos) {
        this.anos = anos;
    }

    public static class Modelo
    {
        public Modelo(Integer codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        private Integer codigo ;
        private String nome;

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }


    }

    public static class Ano
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
