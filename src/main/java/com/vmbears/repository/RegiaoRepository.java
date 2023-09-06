package com.vmbears.repository;

import com.vmbears.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, UUID> {


}
