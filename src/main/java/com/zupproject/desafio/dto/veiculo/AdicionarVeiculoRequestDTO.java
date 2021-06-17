package com.zupproject.desafio.dto.veiculo;

import javax.validation.constraints.NotNull;

public class AdicionarVeiculoRequestDTO {

    @NotNull
    private int idusuario;
    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    @NotNull
    private String anofabricacao;


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
}
