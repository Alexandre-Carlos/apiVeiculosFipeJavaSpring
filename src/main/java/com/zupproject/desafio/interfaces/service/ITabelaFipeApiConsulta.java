package com.zupproject.desafio.interfaces.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zupproject.desafio.model.AnoModelo;
import com.zupproject.desafio.model.MarcaVeiculo;
import com.zupproject.desafio.model.ModeloResponse;
import com.zupproject.desafio.model.ModeloVeiculo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@FeignClient(url="https://parallelum.com.br/fipe/api/v1", name="fipemarca")
public interface ITabelaFipeApiConsulta {

    @RequestMapping(method = RequestMethod.GET, value = "/carros/marcas")
    List<MarcaVeiculo> buscaMarcaCarros();

    @GetMapping("/motos/marcas")
    List<MarcaVeiculo> buscaMarcaMotos();

    @GetMapping("/caminhoes/marcas")
    List<MarcaVeiculo> buscaMarcaCaminhoes();

    @GetMapping(value = "/carros/marcas/{codigo}/modelos", consumes = MediaType.APPLICATION_JSON_VALUE)
    ModeloVeiculo buscaModeloCarros(@PathVariable ("codigo") int codigo);

//    @GetMapping(value = "/carros/marcas/{codigo}/modelos")
//    Optional<ModeloResponse> buscaModeloCarros(@PathVariable ("codigo") int codigo);



    @RequestMapping(method = RequestMethod.GET, value = "/carros/marcas/{codigomarca}/modelos/{codigomodelo}")
    AnoModelo buscaAnoCarros(@PathVariable ("codigomarca") int codigomarca, @PathVariable ("codigomodelo") int codgiomodelo);
}
