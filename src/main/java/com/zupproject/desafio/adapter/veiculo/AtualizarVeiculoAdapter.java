package com.zupproject.desafio.adapter.veiculo;

import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoResponseDTO;
import com.zupproject.desafio.model.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class AtualizarVeiculoAdapter {

    public Veiculo converterRequestParaVeiculo(AtualizarVeiculoRequestDTO request){
        Veiculo veiculo  = new Veiculo();
        veiculo.setIdusuario(request.getIdusuario());
        veiculo.setMarca(request.getMarca());
        veiculo.setModelo(request.getModelo());
        veiculo.setAnofabricacao(request.getAnofabricacao());

        return veiculo;
    }

    public AtualizarVeiculoResponseDTO converterVeiculoParaResponse(Veiculo request){
        AtualizarVeiculoResponseDTO response = new AtualizarVeiculoResponseDTO();

        response.setId(request.getId());
        response.setIdusuario(request.getIdusuario());
        response.setMarca(request.getMarca());
        response.setModelo(request.getModelo());
        response.setAnofabricacao(request.getAnofabricacao());
        response.setValortabelafipe(request.getValortabelafipe());

        return response;
    }

}
