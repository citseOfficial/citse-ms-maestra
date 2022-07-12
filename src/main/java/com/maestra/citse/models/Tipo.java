package com.maestra.citse.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tipo {
    private Integer idTipo;
    private String noTipo;
    private String coAlias;
    private Familia familia;
}
