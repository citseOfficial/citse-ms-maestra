package com.maestra.citse.service;

import com.maestra.citse.entity.Comunidad;

import java.util.List;

public interface ComunidadService {

    List<Comunidad> findAll();

    Comunidad findById(int id_comunidad);

    Comunidad deleteById(int id_comunidad);

    Comunidad save(Comunidad comunidad);

}
