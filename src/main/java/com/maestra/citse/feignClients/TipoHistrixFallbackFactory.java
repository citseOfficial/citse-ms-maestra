package com.maestra.citse.feignClients;

import com.maestra.citse.models.Tipo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoHistrixFallbackFactory implements TipoFeignClient{
    @Override
    public List<Tipo> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Tipo> findById(Integer id) {
        Tipo tipo = Tipo.builder()
                .idTipo(0)
                .coAlias("none")
                .noTipo("none").build();
        return ResponseEntity.ok(tipo);
    }
}
