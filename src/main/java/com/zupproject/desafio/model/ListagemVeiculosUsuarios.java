package com.zupproject.desafio.model;

import javax.persistence.*;


public class ListagemVeiculosUsuarios {


    private int id;


    private int idusuario;


    private String marca;

    private String modelo;

    private String anofabricacao;

    private Double valortabelafipe;

    private String diarodizio;
    private Boolean rodizioativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(String anofabricacao) {
        this.anofabricacao = anofabricacao;
    }

    public Double getValortabelafipe() {
        return valortabelafipe;
    }

    public void setValortabelafipe(Double valortabelafipe) {
        this.valortabelafipe = valortabelafipe;
    }

    public String getDiarodizio() {
        return diarodizio;
    }

    public void setDiarodizio(String diarodizio) {
        this.diarodizio = diarodizio;
    }

    public Boolean getRodizioativo() {
        return rodizioativo;
    }

    public void setRodizioativo(Boolean rodizioativo) {
        this.rodizioativo = rodizioativo;
    }
}
