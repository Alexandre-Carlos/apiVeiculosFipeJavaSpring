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

    public List<MarcaVeiculo> getVeiculoMarca(){
        List<MarcaVeiculo> listaMarcas = fipeService.buscaMarcaCarros();
        return listaMarcas;
    }

    public ModeloVeiculo getVeiculoModelo(int codigoModelo){
        ModeloVeiculo listaModelos = fipeService.buscaModeloCarros(codigoModelo);
        return listaModelos;
    }

   public List<AnoModelo> getVeiculoAno(int codigoMarca, int codigoModelo){
        List<AnoModelo> listaAnoModelo = fipeService.buscaAnoCarros(codigoMarca, codigoModelo);
        return listaAnoModelo;
    }

    public TabelaFipe getVeiculoValor(int codigoMarca, int codigoModelo, String codigoAno){
        TabelaFipe veiculoTabelaFipe = fipeService.buscaValorCarros(codigoMarca, codigoModelo, codigoAno);
        return veiculoTabelaFipe;
    }
}
