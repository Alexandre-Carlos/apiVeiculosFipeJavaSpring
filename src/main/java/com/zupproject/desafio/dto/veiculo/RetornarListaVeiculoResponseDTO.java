package com.zupproject.desafio.dto.veiculo;


import com.zupproject.desafio.model.Veiculo;

import java.util.List;

public class RetornarListaVeiculoResponseDTO {

    public List<Veiculo> veiculos;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
