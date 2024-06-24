package com.cbyk.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Situacao {

    C("Criada"),
    V("Vencida"),
    P("Paga");

    private String descricao;

}
