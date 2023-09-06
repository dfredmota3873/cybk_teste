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
@Table(name = "compra" , schema = "vmbears")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private BigDecimal valor1;
    private BigDecimal valor2;
    private BigDecimal valor3;
    private BigDecimal valor4;
    private BigDecimal valor5;
    private BigDecimal valor6;
    private BigDecimal valor7;
    @OneToOne(mappedBy = "compra")
    private Regiao regiao;

}
