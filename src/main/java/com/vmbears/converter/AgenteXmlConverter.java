package com.vmbears.converter;

import com.vmbears.model.Agente;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AgenteXmlConverter {

    //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    public Agente convertXmlToModel(com.vmbears.api.dto.Agente agente) {

        return Agente.builder()
                .codigo(agente.getCodigo())
                .data(LocalDateTime.parse(agente.getData(),formatter))
                .build();
    }
}
