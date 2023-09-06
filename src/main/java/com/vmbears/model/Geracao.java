package com.vmbears.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "geracao" , schema = "vmbears")
public class Geracao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "valor_1")
    private BigDecimal valor1;
    @Column(name = "valor_2")
    private BigDecimal valor2;
    @Column(name = "valor_3")
    private BigDecimal valor3;
    @Column(name = "valor_4")
    private BigDecimal valor4;
    @Column(name = "valor_5")
    private BigDecimal valor5;
    @Column(name = "valor_6")
    private BigDecimal valor6;
    @Column(name = "valor_7")
    private BigDecimal valor7;
    @OneToOne(mappedBy = "geracao",cascade = CascadeType.ALL)
    private Regiao regiao;

}
