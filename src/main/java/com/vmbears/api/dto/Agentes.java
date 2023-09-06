package com.vmbears.api.dto;


import jakarta.xml.bind.annotation.*;

import java.util.List;


@XmlRootElement
public class Agentes {

    private List<Agente> agente;

    private String versao;

    @XmlElement
    public List<Agente> getAgente() {
        return agente;
    }

    public void setAgente(List<Agente> agente) {
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
