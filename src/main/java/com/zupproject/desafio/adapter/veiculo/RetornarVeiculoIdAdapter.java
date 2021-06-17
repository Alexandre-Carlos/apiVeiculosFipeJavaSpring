package com.zupproject.desafio.adapter.veiculo;

import com.zupproject.desafio.dto.usuario.RetornarUsuarioIdResponseDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoResponseDTO;
import com.zupproject.desafio.dto.veiculo.RetornarVeiculoIdResponseDTO;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.model.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class RetornarVeiculoIdAdapter {

    public RetornarVeiculoIdResponseDTO converterVeiculoParaResponse(Veiculo request){
        RetornarVeiculoIdResponseDTO response = new RetornarVeiculoIdResponseDTO();

        response.setId(request.getId());
        response.setIdusuario(request.getIdusuario());
        response.setMarca(request.getMarca());
        response.setModelo(request.getModelo());
        response.setAnofabricacao(request.getAnofabricacao());
        response.setValortabelafipe(request.getValortabelafipe());

        return response;
    }

    public Veiculo converterResponseParaUsuario(RetornarVeiculoIdResponseDTO request){
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
