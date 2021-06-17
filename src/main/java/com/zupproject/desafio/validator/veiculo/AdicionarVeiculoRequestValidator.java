package com.zupproject.desafio.validator.veiculo;

import com.zupproject.desafio.dto.usuario.AdicionarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AdicionarUsuarioResponseDTO;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoResponseDTO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdicionarVeiculoRequestValidator {

    public AdicionarVeiculoResponseDTO ValidarCamposAdicionarVeiculo(AdicionarVeiculoRequestDTO request) {
        AdicionarVeiculoResponseDTO response = new AdicionarVeiculoResponseDTO();

        List<String> erros = new ArrayList<String>();

        if (request.getMarca().length() > 50 || request.getMarca().length() < 3 ){
            erros.add("Marca deve conter de 3 a 50 caracteres");
        }

        if (request.getModelo().length() > 50 || request.getModelo().length() < 3 ){
            erros.add("Modelo deve conter de 3 a 50 caracteres");
        }

        if (request.getAnofabricacao().length() != 4){
            erros.add("Ano de Fabricação deve conter 4 caracteres");
        }



        response.setMensagem(erros);
        return response;
    }
}
