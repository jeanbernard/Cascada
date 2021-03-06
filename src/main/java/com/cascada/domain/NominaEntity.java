package com.cascada.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "NOMINA", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=NominaEntity.FIND_ALL_NOMINAS, query="Select distinct d from NominaEntity d"),
        @NamedQuery(name=NominaEntity.FIND_NOMINA, query="Select d from NominaEntity d where d.nominaId=:nominaId")
})
public class NominaEntity {

    public static final String FIND_ALL_NOMINAS = "findAllNominas";
    public static final String FIND_NOMINA = "findNomina";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOMINA_ID", nullable = false)
    private Long nominaId;

    @Basic
    @NotNull
    @Size(min=2, max=200, message = "{Size.nomina.nombre}")
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 150)
    private String descripcion;

    @Basic
    @Column(name = "ESTADO", nullable = false)
    private Long estado;


    public Long getNominaId() {
        return nominaId;
    }

    public void setNominaId(Long nominaId) {
        this.nominaId = nominaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NominaEntity that = (NominaEntity) o;

        if (nominaId != that.nominaId) return false;
        if (estado != that.estado) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }
}
