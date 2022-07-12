package com.maestra.citse.controller;

import com.maestra.citse.entity.Comunidad;
import com.maestra.citse.service.ComunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comunidad")
public class ComunidadController {

    @Autowired
    private ComunidadService ComunidadService;


    @GetMapping
    public ResponseEntity<List<Comunidad>> findAll(){
        return ResponseEntity.ok().body(ComunidadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comunidad> findById(@PathVariable int id){
        Comunidad comunidad = ComunidadService.findById(id);

        if (comunidad != null){
            return ResponseEntity.ok().body(ComunidadService.findById(id));
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Comunidad> save (@RequestBody Comunidad comunidad){
        Comunidad c = ComunidadService.save(comunidad);
        return ResponseEntity.ok(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comunidad> update(@RequestBody Comunidad comunidad,@PathVariable Integer id){
        Comunidad c = ComunidadService.findById(id);
        c.setNoComunidad(comunidad.getNoComunidad());
        c.setNuBeneficiarios(comunidad.getNuBeneficiarios());
        ComunidadService.save(c);
        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        ComunidadService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
