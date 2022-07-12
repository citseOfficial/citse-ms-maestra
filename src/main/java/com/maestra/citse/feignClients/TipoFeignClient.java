package com.maestra.citse.feignClients;

import com.maestra.citse.models.Tipo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "citse-ms-tipo",path = "/tipo",fallback = TipoHistrixFallbackFactory.class)
public interface TipoFeignClient {

    @GetMapping("/")
    public List<Tipo> findAll();

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> findById(@PathVariable Integer id);
}
