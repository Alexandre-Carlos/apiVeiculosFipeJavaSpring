package com.zupproject.desafio.adapter.veiculo;

import com.zupproject.desafio.interfaces.service.ITabelaFipeApiConsulta;
import com.zupproject.desafio.model.MarcaVeiculo;
import com.zupproject.desafio.model.ModeloVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ConsultaApiTabelaFipe {

    @Autowired
    //private TabelaFipeRestService tabelafipe;
    private ITabelaFipeApiConsulta tabelafipe;

   public String buscaValorFipe(String marca, String modelo, String anoFabricacao) throws IOException {
        //List<MarcaVeiculo> Listamarca =  tabelafipe.getMarca();

       List<MarcaVeiculo> Listamarca =  tabelafipe.buscaMarcaCarros();

       MarcaVeiculo marcaSelecionada = Listamarca.stream().filter(lista -> lista.getNome().toLowerCase().equals(marca.toLowerCase())).findFirst().get();



       ModeloVeiculo listaModelo =  tabelafipe.buscaModeloCarros(marcaSelecionada.getCodigo());



//       ModeloResponse listaModelo =  tabelafipe.buscaModeloCarros(marcaSelecionada.getCodigo()).get();
//
//
       int codigoModelo = 0;




//       for(Modelo modelos : listaModelo){
//           if(modelos.getNome().equals(modelo)){
//               codigoModelo = modelos.getCodigo();
//           }
//       }


      // AnoModelo listaAnoModelo =  tabelafipe.getAno(marcaSelecionada.getCodigo(), codigoModelo);


      //Modelo modeloSelecionado = listaModelo.stream().filter(lista -> lista.getModelos()).toLowerCase().startsWith(modelo.toLowerCase())).findFirst().get();

        return marcaSelecionada.toString();
   }



}
