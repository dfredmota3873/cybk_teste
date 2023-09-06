package com.vmbears.converter;

import com.vmbears.api.dto.AgenteXML;
import com.vmbears.api.dto.RegiaoXML;
import com.vmbears.api.dto.Valor;
import com.vmbears.model.*;
import com.vmbears.model.enums.TipoRegiao;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgenteXmlConverter {

    //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Agente convertXmlToModel(AgenteXML agente) {

        List<Regiao> regioes =  agente.getRegiao().stream().map(from -> convertXmlToModel(from)).collect(Collectors.toList());

        Agente ag =  Agente.builder()
                .codigo(agente.getCodigo())
                .data(LocalDate.parse(agente.getData().substring(0,10),formatter))
                .build();

        ag.setRegiaoN(regioes.stream()
                .filter(c -> c.getSigla().name().equals("N"))
                .collect(Collectors.toList()).stream().findFirst().get());

        ag.setRegiaoNe(regioes.stream()
                .filter(c -> c.getSigla().name().equals(TipoRegiao.NE.name()))
                .collect(Collectors.toList()).stream().findFirst().get());

        ag.setRegiaoS(regioes.stream()
                .filter(c -> c.getSigla().name().equals(TipoRegiao.S.name()))
                .collect(Collectors.toList()).stream().findFirst().get());

        ag.setRegiaoSe(regioes.stream()
                .filter(c -> c.getSigla().name().equals(TipoRegiao.SE.name()))
                .collect(Collectors.toList()).stream().findFirst().get());

        return ag;
    }

    public Regiao convertXmlToModel(RegiaoXML regiaoXML){

        return Regiao.builder()
                .sigla(TipoRegiao.valueOf(regiaoXML.getSigla()))
                .compra(convertXmlToModelCompra(regiaoXML.getCompra()))
                .geracao(convertXmlToModelGeracao(regiaoXML.getGeracao()))
                .precoMedio(convertXmlToModelPrecoMedio(regiaoXML.getPrecoMedio()))
                .build();
    }

    public Compra convertXmlToModelCompra(Valor compraXml){
        return Compra.builder()
                .valor1(compraXml.getValor().get(0))
                .valor2(compraXml.getValor().get(1))
                .valor3(compraXml.getValor().get(2))
                .valor4(compraXml.getValor().get(3))
                .valor5(compraXml.getValor().get(4))
                .valor6(compraXml.getValor().get(5))
                .valor7(compraXml.getValor().get(6))
                .build();
    }

    public Geracao convertXmlToModelGeracao(Valor compraXml){
        return Geracao.builder()
                .valor1(compraXml.getValor().get(0))
                .valor2(compraXml.getValor().get(1))
                .valor3(compraXml.getValor().get(2))
                .valor4(compraXml.getValor().get(3))
                .valor5(compraXml.getValor().get(4))
                .valor6(compraXml.getValor().get(5))
                .valor7(compraXml.getValor().get(6))
                .build();
    }

    public PrecoMedio convertXmlToModelPrecoMedio(Valor compraXml){
        return PrecoMedio.builder()
                .valor1(compraXml.getValor().get(0))
                .valor2(compraXml.getValor().get(1))
                .valor3(compraXml.getValor().get(2))
                .valor4(compraXml.getValor().get(3))
                .valor5(compraXml.getValor().get(4))
                .valor6(compraXml.getValor().get(5))
                .valor7(compraXml.getValor().get(6))
                .build();
    }
}
