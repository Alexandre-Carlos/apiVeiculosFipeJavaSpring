package com.zupproject.desafio.usecases.listagem;

import com.zupproject.desafio.adapter.listagem.RetornarListagemVeiculoUsuarioAdapter;
import com.zupproject.desafio.dto.listagem.RetornarListagemVeiculoUsuarioResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.listagem.IRetornarListagemVeiculoUsuarioUseCases;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryListagemVeiculoImp;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetornarListagemVeiculoUsuarioUseCase implements IRetornarListagemVeiculoUsuarioUseCases {

    @Autowired
    private RepositoryListagemVeiculoImp repository;

    @Autowired
    private RetornarListagemVeiculoUsuarioAdapter adapter;

    @Override
    public List<RetornarListagemVeiculoUsuarioResponseDTO> Executar(int idUsuario) {

        List<RetornarListagemVeiculoUsuarioResponseDTO> response = new ArrayList<>();

        try{
            List<Veiculo> listaVeiculo = repository.findByIdusuario(idUsuario);

            response = listaVeiculo.stream().map(adapter::converterVeiculoParaResponse).collect(Collectors.toList());

            response.stream().forEach(lista -> lista.setDiarodizio(this.diaRodizio(lista.getAnofabricacao())));

            response.stream().forEach(lista -> lista.setRodizioativo(this.rodizioAtivo(lista.getDiarodizio())));

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);
        }

        return response;
    }

    public String diaRodizio(String anoFabricacao){
        String rodizioDia = anoFabricacao.substring(3);
        String diaSemana = "";
        switch (rodizioDia){
            case "0": diaSemana = "segunda-feira";
                break;
            case "1": diaSemana = "segunda-feira";
                break;
            case "2": diaSemana = "terça-feira";
                break;
            case "3": diaSemana = "terça-feira";
                break;
            case "4": diaSemana = "quarta-feira";
                break;
            case "5": diaSemana = "quarta-feira";
                break;
            case "6": diaSemana = "quinta-feira";
                break;
            case "7": diaSemana = "quinta-feira";
                break;
            case "8": diaSemana = "sexta-feira";
                break;
            case "9": diaSemana = "sexta-feira";
                break;
            default:
                throw  new BusinessException(MessageUtil.CAMPOS_INVALIDOS);
        }
        return diaSemana;
    }

    public Boolean rodizioAtivo(String diaRodizio){
        String dayWeek = "---";
        boolean rodizio = false;
        LocalDate dataAtual = LocalDate.now();
        GregorianCalendar gc = new GregorianCalendar();
        try {

            switch (dataAtual.getDayOfWeek()) {
                case MONDAY:
                    if(diaRodizio == "segunda-feira"){
                        rodizio = true;
                    }
                    break;
                case TUESDAY:
                    if(diaRodizio == "terça-feira"){
                        rodizio = true;
                    }
                    break;
                case WEDNESDAY:
                    if(diaRodizio == "quarta-feira"){
                        rodizio = true;
                    }
                    break;
                case THURSDAY:
                    if(diaRodizio == "quinta-feira"){
                        rodizio = true;
                    }
                    break;
                case FRIDAY:
                    if(diaRodizio == "sexta-feira"){
                        rodizio = true;
                    }
                    break;
                default:
                    rodizio = false;
                    break;
            }
        } catch (Exception e) {
            throw  new BusinessException(MessageUtil.CAMPOS_INVALIDOS);
        }
        return rodizio;
    }
}
