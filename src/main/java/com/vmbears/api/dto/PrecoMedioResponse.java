package com.vmbears.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PrecoMedioResponse {

    private BigDecimal valor1;
    private BigDecimal valor2;
    private BigDecimal valor3;
    private BigDecimal valor4;
    private BigDecimal valor5;
    private BigDecimal valor6;
    private BigDecimal valor7;

}
