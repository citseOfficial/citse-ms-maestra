package com.maestra.citse.service;

import com.maestra.citse.entity.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> findAll();
    public List<Persona> findTop10ByNoPersonaContains(String nombre);
    public Persona findByNuIndentificacion(String numero);
    Persona findById(int id_persona);

    Persona deleteById(int id_persona);

    Persona save(Persona persona);

}
