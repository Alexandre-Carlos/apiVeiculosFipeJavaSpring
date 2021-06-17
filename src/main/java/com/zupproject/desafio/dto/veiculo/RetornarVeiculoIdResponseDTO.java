package com.zupproject.desafio.dto.veiculo;

public class RetornarVeiculoIdResponseDTO {

    private int id;
    private int idusuario;

    private String marca;

    private String modelo;

    private String anofabricacao;

    private Double valortabelafipe;


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
}
