package com.vmbears.repository;

import com.vmbears.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AgenteRepository extends JpaRepository<Agente, UUID> {


}
