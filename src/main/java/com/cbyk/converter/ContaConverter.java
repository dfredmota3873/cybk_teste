package com.cbyk.converter;

import com.cbyk.api.dto.request.ContaRequest;
import com.cbyk.api.dto.response.ContaResponse;
import com.cbyk.model.Conta;
import com.cbyk.model.enums.Situacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ContaConverter {

    public Conta toModel(ContaRequest request){

        return Conta.builder()
                .dataVencimento(request.getDataVencimento())
                .descricao(request.getDescricao())
                .situacao(Situacao.valueOf(request.getSituacao()))
                .valor(request.getValor())
                .build();

    }

    public Conta toModelUpdate(ContaRequest request){

        return Conta.builder()
                .dataVencimento(request.getDataVencimento())
                .descricao(request.getDescricao())
                .dataPagamento(request.getDataPagamento())
                .situacao(Situacao.valueOf(request.getSituacao()))
                .valor(request.getValor())
                .build();

    }

    public ContaResponse toResponse(Conta conta){

        return ContaResponse.builder()
                .id(conta.getId())
                .dataPagamento(conta.getDataPagamento())
                .dataVencimento(conta.getDataVencimento())
                .descricao(conta.getDescricao())
                .valor(conta.getValor())
                .situacao(conta.getSituacao().getDescricao())
                .build();
    }

    public List<ContaResponse> ToListResponse(List<Conta> listEntity){
        return listEntity.stream().map(this::toResponse).toList();
    }
}
