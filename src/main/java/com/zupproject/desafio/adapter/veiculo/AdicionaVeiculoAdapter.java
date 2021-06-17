package com.zupproject.desafio.adapter.veiculo;



import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoResponseDTO;
import com.zupproject.desafio.model.Veiculo;
import org.springframework.stereotype.Service;

@Service
public class AdicionaVeiculoAdapter {

    public Veiculo converterRequestParaVeiculo(AdicionarVeiculoRequestDTO request){
        Veiculo veiculo  = new Veiculo();
        veiculo.setIdusuario(request.getIdusuario());
        veiculo.setMarca(request.getMarca());
        veiculo.setModelo(request.getModelo());
        veiculo.setAnofabricacao(request.getAnofabricacao());

        return veiculo;
    }

    public AdicionarVeiculoResponseDTO converterVeiculoParaResponse(Veiculo request){
        AdicionarVeiculoResponseDTO response = new AdicionarVeiculoResponseDTO();

        response.setId(request.getId());
        response.setIdusuario(request.getIdusuario());
        response.setMarca(request.getMarca());
        response.setModelo(request.getModelo());
        response.setAnofabricacao(request.getAnofabricacao());
        response.setValortabelafipe(request.getValortabelafipe());
        return response;
    }

}
