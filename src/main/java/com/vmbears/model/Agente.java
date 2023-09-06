package com.vmbears.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "regiao_n_id")
    Regiao regiaoN;

    @ManyToOne
    @JoinColumn(name = "regiao_ne_id")
    Regiao regiaoNe;

    @ManyToOne
    @JoinColumn(name = "regiao_s_id")
    Regiao regiaoS;

    @ManyToOne
    @JoinColumn(name = "regiao_se_id")
    Regiao regiaoSe;

}
