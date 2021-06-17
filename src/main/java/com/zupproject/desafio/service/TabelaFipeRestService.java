package com.zupproject.desafio.service;

import com.zupproject.desafio.interfaces.service.ITabelaFipeApiConsulta;
import com.zupproject.desafio.model.MarcaVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaFipeRestService {

    @Autowired
    private ITabelaFipeApiConsulta fipeService;

    public List<MarcaVeiculo> getMarca(){
        List<MarcaVeiculo> listaMarcas = fipeService.buscaMarcaCarros();
        return listaMarcas;
    }

//    public List<ModeloVeiculo> getModelo(int codigoModelo){
//        List<ModeloVeiculo> listaModelos = fipeService.buscaModeloCarros(codigoModelo);
//        return listaModelos;
//    }

//    public ModeloResponse getModelo(int codigoModelo){
//        ModeloResponse listaModelos = fipeService.buscaModeloCarros(codigoModelo);
//        return listaModelos;
//    }
//
//    public AnoModelo getAno(int codigoMarca, int codigoModelo){
//        AnoModelo listaAnoModelo = fipeService.buscaAnoCarros(codigoMarca, codigoModelo);
//        return listaAnoModelo;
//    }
}
