package com.zupproject.desafio.interfaces.service;

import com.zupproject.desafio.model.AnoModelo;
import com.zupproject.desafio.model.MarcaVeiculo;
import com.zupproject.desafio.model.ModeloVeiculo;
import com.zupproject.desafio.model.TabelaFipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url="https://parallelum.com.br/fipe/api/v1", name="fipe")
public interface ITabelaFipeApiConsulta {

    @GetMapping(value = "/carros/marcas")
    List<MarcaVeiculo> buscaMarcaCarros();

    @GetMapping("/motos/marcas")
    List<MarcaVeiculo> buscaMarcaMotos();

    @GetMapping("/caminhoes/marcas")
    List<MarcaVeiculo> buscaMarcaCaminhoes();

    @GetMapping(value = "/carros/marcas/{codigo}/modelos", consumes = MediaType.APPLICATION_JSON_VALUE)
    ModeloVeiculo buscaModeloCarros(@PathVariable ("codigo") Integer codigo);

    @GetMapping(value = "/carros/marcas/{codigomarca}/modelos/{codigomodelo}/anos", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<AnoModelo> buscaAnoCarros(@PathVariable ("codigomarca") Integer codigomarca,
               @PathVariable ("codigomodelo") Integer codigomodelo);

    @GetMapping(value = "/carros/marcas/{codigomarca}/modelos/{codigomodelo}/anos/{ano}", consumes = MediaType.APPLICATION_JSON_VALUE)
    TabelaFipe buscaValorCarros(@PathVariable("codigomarca") Integer codigomarca,
               @PathVariable("codigomodelo") Integer codigomodelo, @PathVariable("ano") String ano);

}
