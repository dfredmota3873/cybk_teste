package com.vmbears.repository;

import com.vmbears.model.Agente;
import com.vmbears.model.enums.TipoRegiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.List;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, UUID> {


    @Query("SELECT ag FROM Agente ag WHERE ag.regiaoN.sigla = :sigla or ag.regiaoNe.sigla = :sigla or ag.regiaoS.sigla = :sigla or ag.regiaoSe.sigla = :sigla ")
    List<Agente> buscarAgentesPorRegiao(@Param(value = "sigla") TipoRegiao sigla);

}
