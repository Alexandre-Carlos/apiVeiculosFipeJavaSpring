package com.zupproject.desafio.validator.veiculo;

import com.zupproject.desafio.dto.usuario.AtualizarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AtualizarUsuarioResponseDTO;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoResponseDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AtualizarVeiculoResponseDTO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtualizarVeiculoRequestValidator {

    public AtualizarVeiculoResponseDTO ValidarCamposAtualizarVeiculo(AtualizarVeiculoRequestDTO request) {
        AtualizarVeiculoResponseDTO response = new AtualizarVeiculoResponseDTO();

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
