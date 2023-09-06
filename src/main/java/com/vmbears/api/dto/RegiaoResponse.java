package com.vmbears.api.dto;

import com.vmbears.model.enums.TipoRegiao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RegiaoResponse {

    private TipoRegiao sigla;

    private GeracaoResponse geracao;

    private CompraResponse compra;

    private PrecoMedioResponse precoMedio;


}
