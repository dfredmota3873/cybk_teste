package com.vmbears.model;

import com.vmbears.model.enums.TipoRegiao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "regiao" , schema = "vmbears")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoRegiao sigla;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geracao_id", referencedColumnName = "id")
    private Geracao geracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compra_id", referencedColumnName = "id")
    private Compra compra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preco_medio_id", referencedColumnName = "id")
    private PrecoMedio precoMedio;
}
