package com.vmbears.api.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.List;

@XmlRootElement
public class Valor {

    private List<BigDecimal> valor;

    @XmlElement
    public List<BigDecimal> getValor() {
        return valor;
    }

    public void setValor(List<BigDecimal> valor) {
        this.valor = valor;
    }
}
