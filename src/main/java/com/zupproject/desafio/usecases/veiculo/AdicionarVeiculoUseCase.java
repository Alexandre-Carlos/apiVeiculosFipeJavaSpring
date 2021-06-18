package com.zupproject.desafio.usecases.veiculo;


import com.zupproject.desafio.adapter.veiculo.AdicionaVeiculoAdapter;
import com.zupproject.desafio.adapter.veiculo.ConsultaApiTabelaFipe;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoRequestDTO;
import com.zupproject.desafio.dto.veiculo.AdicionarVeiculoResponseDTO;
import com.zupproject.desafio.exceptions.BusinessException;
import com.zupproject.desafio.interfaces.usecases.veiculo.IAdicionarVeiculoUseCases;
import com.zupproject.desafio.model.TabelaFipe;
import com.zupproject.desafio.model.Usuario;
import com.zupproject.desafio.model.Veiculo;
import com.zupproject.desafio.repository.RepositoryUsuarioImp;
import com.zupproject.desafio.repository.RepositoryVeiculoImp;
import com.zupproject.desafio.util.MessageUtil;
import com.zupproject.desafio.validator.veiculo.AdicionarVeiculoRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdicionarVeiculoUseCase implements IAdicionarVeiculoUseCases {

    @Autowired
    private RepositoryVeiculoImp repository;

    @Autowired
    private RepositoryUsuarioImp repositoryUsuario;

    @Autowired
    private AdicionaVeiculoAdapter adapter;

    @Autowired
    private ConsultaApiTabelaFipe tableFipeValor;

    @Override
    public AdicionarVeiculoResponseDTO Executar(AdicionarVeiculoRequestDTO request) {

        AdicionarVeiculoResponseDTO response = new AdicionarVeiculoResponseDTO();

        List<String> erros = new ArrayList<String>();

        try{
            Usuario verificaUsuarioCadastrado = repositoryUsuario.findById(request.getIdusuario());

        }catch (Exception ex){
            throw new BusinessException(MessageUtil.REGISTRO_NAO_ENCONTRADO);

        }

        AdicionarVeiculoRequestValidator validacao = new AdicionarVeiculoRequestValidator();

        try {

            response = validacao.ValidarCamposAdicionarVeiculo(request);

            if(response.getMensagem().size() > 0){
                //response.setMensagem(response.getMensagem());
                throw new BusinessException(MessageUtil.CAMPOS_INVALIDOS);
                //return response;
            }

            Veiculo veiculoAdicionar = adapter.converterRequestParaVeiculo(request);

            TabelaFipe veiculoRetornoApi = tableFipeValor.buscaValorFipe(veiculoAdicionar.getMarca(),veiculoAdicionar.getModelo(), veiculoAdicionar.getAnofabricacao());

            String valorVeiculo = veiculoRetornoApi.getValor().replaceAll( "\\." , "" )
                    .replaceAll("\\,", ".")
                    .substring(3);


            veiculoAdicionar.setValortabelafipe(Double.parseDouble(valorVeiculo));

            repository.save(veiculoAdicionar);

            response = adapter.converterVeiculoParaResponse(veiculoAdicionar);


            return response;

        } catch(Exception ex) {
//            erros.add("Erro ao adicionar o Veículo!");
//            response.setMensagem(erros);
//            return response;
            throw new BusinessException(MessageUtil.USUARIO_INVALIDO);
        }

    }
}
