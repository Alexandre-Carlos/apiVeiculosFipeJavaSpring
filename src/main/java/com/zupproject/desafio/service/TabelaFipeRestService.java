package com.zupproject.desafio.service;

import com.zupproject.desafio.interfaces.service.ITabelaFipeApiConsulta;
import com.zupproject.desafio.model.AnoModelo;
import com.zupproject.desafio.model.MarcaVeiculo;
import com.zupproject.desafio.model.ModeloVeiculo;
import com.zupproject.desafio.model.TabelaFipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaFipeRestService  {

    @Autowired
    private ITabelaFipeApiConsulta fipeService;

    public List<MarcaVeiculo> getMarca(){
        List<MarcaVeiculo> listaMarcas = fipeService.buscaMarcaCarros();
        return listaMarcas;
    }

    public ModeloVeiculo getModelo(int codigoModelo){
        ModeloVeiculo listaModelos = fipeService.buscaModeloCarros(codigoModelo);
        return listaModelos;
    }

   public List<AnoModelo> getAno(int codigoMarca, int codigoModelo){
        List<AnoModelo> listaAnoModelo = fipeService.buscaAnoCarros(codigoMarca, codigoModelo);
        return listaAnoModelo;
    }

    public TabelaFipe getValor(int codigoMarca, int codigoModelo, String codigoAno){
        TabelaFipe veiculoTabelaFipe = fipeService.buscaValorCarros(codigoMarca, codigoModelo, codigoAno);
        return veiculoTabelaFipe;
    }


}
