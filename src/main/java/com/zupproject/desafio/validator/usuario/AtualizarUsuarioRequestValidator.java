package com.zupproject.desafio.validator.usuario;

import com.zupproject.desafio.dto.usuario.AdicionarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AdicionarUsuarioResponseDTO;
import com.zupproject.desafio.dto.usuario.AtualizarUsuarioRequestDTO;
import com.zupproject.desafio.dto.usuario.AtualizarUsuarioResponseDTO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtualizarUsuarioRequestValidator {

    public AtualizarUsuarioResponseDTO ValidarCamposAtualizarUsuario(AtualizarUsuarioRequestDTO request) {
        AtualizarUsuarioResponseDTO response = new AtualizarUsuarioResponseDTO();

        List<String> erros = new ArrayList<String>();

        if (request.getNome().length() > 100 || request.getNome().length() < 3 ){
            erros.add("Nome deve conter de 3 a 20 caracteres");
        }

        if (verificaRegex("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", request.getEmail()) == false){
            erros.add("Email digitado incorretamente!");
        };


        if (verificaRegex("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", request.getCpf()) == false){
            erros.add("Cpf digitado incorretamente!");
        };

        if(!validaData(request.getDatanascimento())){
            erros.add("Data incorreta ou maior que o dia atual!");
        }

        response.setMensagem(erros);
        return response;
    }

    public boolean verificaRegex(String regex, String campo){

        Pattern pattern = Pattern.compile(regex);

        Matcher verificaCampo = pattern.matcher(campo);

        return verificaCampo.matches();
    }

    public static boolean validaData(LocalDate data) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            LocalDate dataHoje = LocalDate.now();

            if(data.compareTo(dataHoje) > 0){
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }


    }
}
