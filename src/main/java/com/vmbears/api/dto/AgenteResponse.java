package com.vmbears.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AgenteResponse {

    private Integer codigo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private RegiaoResponse regiaoN;

    private RegiaoResponse regiaoNe;

    private RegiaoResponse regiaoS;

    private RegiaoResponse regiaoSe;

}
