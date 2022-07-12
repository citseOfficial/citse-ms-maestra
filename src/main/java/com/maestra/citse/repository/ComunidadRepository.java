package com.maestra.citse.repository;

import com.maestra.citse.entity.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Integer> {
}
