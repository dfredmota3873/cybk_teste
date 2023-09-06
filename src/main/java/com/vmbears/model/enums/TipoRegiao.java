package com.vmbears.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoRegiao {

    SE("Sudeste"),
    S("Sul"),
    NE("Nordeste"),
    N("Norte");

    private String description;

}
