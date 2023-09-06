package com.vmbears.converter;

import com.vmbears.api.dto.*;
import com.vmbears.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgentesConverter {

    public AgenteResponse convertModelToResponse(Agente model){

        return AgenteResponse.builder()
                .codigo(model.getCodigo())
                .data(model.getData())
                .regiaoSe(convertModelToResponse(model.getRegiaoSe()))
                .regiaoN(convertModelToResponse(model.getRegiaoN()))
                .regiaoS(convertModelToResponse(model.getRegiaoS()))
                .regiaoSe(convertModelToResponse(model.getRegiaoSe()))
                .build();
    }

    public RegiaoResponse convertModelToResponse(Regiao regiao){

        return RegiaoResponse.builder()
                .sigla(regiao.getSigla())
                .compra(convertToModelCompra(regiao.getCompra()))
                .geracao(convertToModelGeracao(regiao.getGeracao()))
                .precoMedio(convertToModelPrecoMedio(regiao.getPrecoMedio()))
                .build();
    }

    public CompraResponse convertToModelCompra(Compra model){
        return CompraResponse.builder()
                .valor1(model.getValor1())
                .valor2(model.getValor2())
                .valor3(model.getValor3())
                .valor4(model.getValor4())
                .valor5(model.getValor5())
                .valor6(model.getValor6())
                .valor7(model.getValor7())
                .build();
    }

    public GeracaoResponse convertToModelGeracao(Geracao model){
        return GeracaoResponse.builder()
                .valor1(model.getValor1())
                .valor2(model.getValor2())
                .valor3(model.getValor3())
                .valor4(model.getValor4())
                .valor5(model.getValor5())
                .valor6(model.getValor6())
                .valor7(model.getValor7())
                .build();
    }

    public PrecoMedioResponse convertToModelPrecoMedio(PrecoMedio model){
        return PrecoMedioResponse.builder()
                .valor1(model.getValor1())
                .valor2(model.getValor2())
                .valor3(model.getValor3())
                .valor4(model.getValor4())
                .valor5(model.getValor5())
                .valor6(model.getValor6())
                .valor7(model.getValor7())
                .build();
    }

    public List<AgenteResponse> convertListModelToResponse(List<Agente> list){
        return list.stream().map(from -> convertModelToResponse(from)).collect(Collectors.toList());
    }
}
