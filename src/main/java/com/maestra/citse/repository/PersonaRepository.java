package com.maestra.citse.repository;

import com.maestra.citse.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    public List<Persona> findTop10ByNoPersonaContains(String nombre);
    public Persona findByNuIndentificacion(String numero);
}
