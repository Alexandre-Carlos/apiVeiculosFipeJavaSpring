package com.zupproject.desafio.adapter.listagem;

import com.zupproject.desafio.dto.listagem.RetornarListagemVeiculoUsuarioResponseDTO;
import com.zupproject.desafio.dto.veiculo.RetornarVeiculoIdResponseDTO;
import com.zupproject.desafio.model.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class RetornarListagemVeiculoUsuarioAdapter {

    public RetornarListagemVeiculoUsuarioResponseDTO converterVeiculoParaResponse(Veiculo request){
        RetornarListagemVeiculoUsuarioResponseDTO response = new RetornarListagemVeiculoUsuarioResponseDTO();

        response.setId(request.getId());
        response.setIdusuario(request.getIdusuario());
        response.setMarca(request.getMarca());
        response.setModelo(request.getModelo());
        response.setAnofabricacao(request.getAnofabricacao());
        response.setValortabelafipe(request.getValortabelafipe());

        return response;
    }

    public Veiculo converterResponseParaVeiculo(RetornarVeiculoIdResponseDTO request){
        Veiculo veiculo = new Veiculo();
        veiculo.setId(request.getId());
        veiculo.setIdusuario(request.getIdusuario());
        veiculo.setMarca(request.getMarca());
        veiculo.setModelo(request.getModelo());
        veiculo.setAnofabricacao(request.getAnofabricacao());
        veiculo.setValortabelafipe(request.getValortabelafipe());

        return veiculo;
    }




}
