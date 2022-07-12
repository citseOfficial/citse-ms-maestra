package com.maestra.citse.feignClients;

import com.maestra.citse.models.Distrito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "citse-ms-ubigeo",path = "/distrito")
public interface UbigeoFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Distrito> getDistrito(@PathVariable Integer id);
}
