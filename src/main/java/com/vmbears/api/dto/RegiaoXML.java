package com.vmbears.api.dto;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "regiao")
public class RegiaoXML {

    private String sigla;
    private Valor compra;
    private Valor geracao;
    private Valor precoMedio;

    @XmlElement(name = "compra")
    public Valor getCompra() {
        return compra;
    }

    public void setCompra(Valor compra) {
        this.compra = compra;
    }

    @XmlElement(name = "geracao")
    public Valor getGeracao() {
        return geracao;
    }

    public void setGeracao(Valor geracao) {
        this.geracao = geracao;
    }

    @XmlElement(name = "precoMedio")
    public Valor getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(Valor precoMedio) {
        this.precoMedio = precoMedio;
    }

    @XmlAttribute(name = "sigla")
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
