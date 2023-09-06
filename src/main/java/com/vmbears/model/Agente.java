package com.vmbears.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "agente" , schema = "vmbears")
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer codigo;
    @Temporal(TemporalType.DATE)
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regiao_n_id")
    private Regiao regiaoN;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regiao_ne_id")
    private Regiao regiaoNe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regiao_s_id")
    private Regiao regiaoS;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regiao_se_id")
    private Regiao regiaoSe;

}
