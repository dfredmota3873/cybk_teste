package com.vmbears.api.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "agente")
public class AgenteXML implements Serializable {

    private Integer codigo;

    private String data;

    private List<RegiaoXML> regiao;


    public AgenteXML(Integer codigo, String data) {
        this.codigo = codigo;
        this.data = data;
    }

    public AgenteXML() {
    }

    @XmlElement
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @XmlElement
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @XmlElement(name = "regiao")
    public List<RegiaoXML> getRegiao() {
        return regiao;
    }

    public void setRegiao(List<RegiaoXML> regiao) {
        this.regiao = regiao;
    }
}
