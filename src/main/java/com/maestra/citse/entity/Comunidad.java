package com.maestra.citse.entity;

import com.maestra.citse.models.Distrito;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TMA_COMUNIDADES")
@Data
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunidad")
    private Integer idComunidad;

    @Column(name = "no_comunidad")
    private String noComunidad;

    @Column(name = "nu_beneficiarios")
    private Integer nuBeneficiarios;

    @Column(name = "es_comunidad")
    private Boolean esComunidad;

    @Column(name = "id_distrito")
    private Integer idDistrito;

    @Transient
    private Distrito distrito;

    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.ALL)
    List<Persona> personas;

}
