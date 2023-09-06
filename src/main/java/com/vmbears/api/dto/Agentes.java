package com.vmbears.api.dto;


import jakarta.xml.bind.annotation.*;

import java.util.List;


@XmlRootElement(name = "agentes")
public class Agentes {

    private List<AgenteXML> agente;

    private String versao;

    @XmlElement(name = "agente")
    public List<AgenteXML> getAgente() {
        return agente;
    }

    public void setAgente(List<AgenteXML> agente) {
        this.agente = agente;
    }

    @XmlAttribute(name = "versao")
    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
