package com.maestra.citse.controller;

import com.maestra.citse.entity.Persona;
import com.maestra.citse.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    @GetMapping
    public ResponseEntity<List<Persona>> findAll(@RequestParam(name = "nombre",required = false)String nombre){
        List<Persona> p = new ArrayList<>();
        if(nombre==null){
            p=personaService.findAll();
            if(p.isEmpty())
                return ResponseEntity.noContent().build();
        } else  {
            p=personaService.findTop10ByNoPersonaContains(nombre);
            if (p.isEmpty())
                return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable int id){
        Persona persona = personaService.findById(id);

        if (persona != null){
            return ResponseEntity.ok().body(personaService.findById(id));
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("dni/{dni}")
    public Persona findByIdentificacion(@PathVariable String dni){
        return personaService.findByNuIndentificacion(dni);
    }

    @PostMapping
    public Persona save(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@RequestBody Persona persona, @PathVariable Integer id){
        Persona p = personaService.findById(id);
        p.setNoPersona(persona.getNoPersona());
        p.setApPaterno(persona.getApPaterno());
        p.setApMaterno(persona.getApMaterno());
        p.setNuIndentificacion(persona.getNuIndentificacion());
        p.setFeNacimiento(persona.getFeNacimiento());
        p.setIdTiIndentificacion(persona.getIdTiIndentificacion());
        p.setIdTiPersona(persona.getIdTiPersona());
        p.setIdTiEsCivil(persona.getIdTiEsCivil());
        p.setComunidad(persona.getComunidad());

        personaService.save(p);
        return p;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        personaService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
