package com.maestra.citse.serviceImp;

import com.maestra.citse.entity.Persona;
import com.maestra.citse.feignClients.TipoFeignClient;
import com.maestra.citse.models.Tipo;
import com.maestra.citse.repository.PersonaRepository;
import com.maestra.citse.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private TipoFeignClient tipoFeignClient;

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public List<Persona> findTop10ByNoPersonaContains(String nombre) {
        return personaRepository.findTop10ByNoPersonaContains(nombre);
    }

    @Override
    public Persona findByNuIndentificacion(String numero) {
        Persona p = personaRepository.findByNuIndentificacion(numero);
        if(p!=null){
            Tipo tipoIdentificacion = tipoFeignClient.findById(p.getIdTiIndentificacion()).getBody();
            p.setTipoIdentificacion(tipoIdentificacion);
            Tipo tipoPersona = tipoFeignClient.findById(p.getIdTiPersona()).getBody();
            p.setTipoPersona(tipoPersona);
            Tipo esCivil = tipoFeignClient.findById(p.getIdTiEsCivil()).getBody();
            p.setEsCivil(esCivil);
        }
        return p;
    }

    @Override
    public Persona findById(int id_persona) {
        Persona p = personaRepository.findById(id_persona).orElse(null);
        if(p!=null){
            Tipo tipoIdentificacion = tipoFeignClient.findById(p.getIdTiIndentificacion()).getBody();
            p.setTipoIdentificacion(tipoIdentificacion);
            Tipo tipoPersona = tipoFeignClient.findById(p.getIdTiPersona()).getBody();
            p.setTipoPersona(tipoPersona);
            Tipo esCivil = tipoFeignClient.findById(p.getIdTiEsCivil()).getBody();
            p.setEsCivil(esCivil);
        }
        return p;
    }

    @Override
    public Persona deleteById(int id_persona) {
        Persona personaState = findById(id_persona);
        personaState.setEsPersona(false);
        personaRepository.save(personaState);
        return personaState;
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }
}
