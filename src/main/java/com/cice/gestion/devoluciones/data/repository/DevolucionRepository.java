package com.cice.gestion.devoluciones.data.repository;

import com.cice.gestion.devoluciones.data.entity.DevolucionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionRepository extends JpaRepository<DevolucionEntity, Long>{
}
