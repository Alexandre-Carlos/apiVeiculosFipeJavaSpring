package com.zupproject.desafio.adapter.veiculo;

import com.zupproject.desafio.interfaces.service.ITabelaFipeApiConsulta;
import com.zupproject.desafio.model.AnoModelo;
import com.zupproject.desafio.model.MarcaVeiculo;
import com.zupproject.desafio.model.ModeloVeiculo;
import com.zupproject.desafio.model.TabelaFipe;
import com.zupproject.desafio.service.TabelaFipeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ConsultaApiTabelaFipe {

    @Autowired
    private TabelaFipeRestService tabelafipe;
    //private ITabelaFipeApiConsulta tabelafipe;

   public TabelaFipe buscaValorFipe(String marca, String modelo, String anoFabricacao) throws IOException {
        //List<MarcaVeiculo> Listamarca =  tabelafipe.getMarca();

       List<MarcaVeiculo> Listamarca =  tabelafipe.getMarca();

       MarcaVeiculo marcaSelecionada = Listamarca.stream().filter(lista -> lista.getNome().toLowerCase().equals(marca.toLowerCase())).findFirst().get();



       ModeloVeiculo listaModelo =  tabelafipe.getModelo(marcaSelecionada.getCodigo());

       List<ModeloVeiculo.Modelo> listaModeloVeiculo = listaModelo.getModelos();

       ModeloVeiculo.Modelo modeloSelecionado =  listaModeloVeiculo.stream().filter(m -> m.getNome().toLowerCase().startsWith(modelo.toLowerCase())).findFirst().get();


      List<AnoModelo> listaAnoModelo =  tabelafipe.getAno(marcaSelecionada.getCodigo(), modeloSelecionado.getCodigo());

      AnoModelo anoSelecionado = listaAnoModelo.stream().filter(lista -> lista.getNome().startsWith(anoFabricacao)).findFirst().get();

       TabelaFipe veiculoSelecionado = tabelafipe.getValor(marcaSelecionada.getCodigo(), modeloSelecionado.getCodigo(), anoSelecionado.getCodigo());

      return veiculoSelecionado;
   }



}
