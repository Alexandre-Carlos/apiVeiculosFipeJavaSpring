package com.zupproject.desafio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TabelaFipe {

    public TabelaFipe(String valor, String marca, String modelo, Integer anomodelo, String combustivel, String codigofipe, String mesreferencia, Integer tipoveiculo, String siglacombustivel) {


        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.anomodelo = anomodelo;
        this.combustivel = combustivel;
        this.codigofipe = codigofipe;
        this.mesreferencia = mesreferencia;
        this.tipoveiculo = tipoveiculo;
        this.siglacombustivel = siglacombustivel;
    }

    @JsonProperty("Valor")
    private String valor;
    @JsonProperty("Marca")
    private String marca;
    @JsonProperty("Modelo")
    private String modelo;
    @JsonProperty("AnoModelo")
    private Integer anomodelo;
    @JsonProperty("Combustivel")
    private String combustivel;
    @JsonProperty("CodigoFipe")
    private String codigofipe;
    @JsonProperty("MesReferencia")
    private String mesreferencia;
    @JsonProperty("TipoVeiculo")
    private Integer tipoveiculo;
    @JsonProperty("SiglaCombustivel")
    private String siglacombustivel;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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

    public Integer getAnomodelo() {
        return anomodelo;
    }

    public void setAnomodelo(Integer anomodelo) {
        this.anomodelo = anomodelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigofipe() {
        return codigofipe;
    }

    public void setCodigofipe(String codigofipe) {
        this.codigofipe = codigofipe;
    }

    public String getMesreferencia() {
        return mesreferencia;
    }

    public void setMesreferencia(String mesreferencia) {
        this.mesreferencia = mesreferencia;
    }

    public Integer getTipoveiculo() {
        return tipoveiculo;
    }

    public void setTipoveiculo(Integer tipoveiculo) {
        this.tipoveiculo = tipoveiculo;
    }

    public String getSiglacombustivel() {
        return siglacombustivel;
    }

    public void setSiglacombustivel(String siglacombustivel) {
        this.siglacombustivel = siglacombustivel;
    }
}
