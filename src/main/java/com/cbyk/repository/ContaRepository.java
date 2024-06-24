package com.cbyk.repository;

import com.cbyk.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID> {

    @Query("SELECT ct FROM Conta ct WHERE ct.descricao = :descricao " +
    "and  ct.dataVencimento BETWEEN :dataInicio AND :dataFim  order by ct.descricao asc")
    List<Conta> listar(@Param(value = "descricao") String descricao,
                       @Param(value = "dataInicio") LocalDate dataInicio,
                       @Param(value = "dataFim") LocalDate dataFim);

    @Query("SELECT sum(ct.valor) FROM Conta ct WHERE " +
            "ct.dataVencimento BETWEEN :dataInicio AND :dataFim")
    BigDecimal valorTotalPorPeriodo(@Param(value = "dataInicio") LocalDate dataInicio,
                                    @Param(value = "dataFim") LocalDate dataFim);

}
