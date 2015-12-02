package com.cascada.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "INGRESO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=IngresoEntity.FIND_ALL_INGRESOS, query="Select distinct p from IngresoEntity p"),
        @NamedQuery(name=IngresoEntity.FIND_INGRESO, query="Select p from IngresoEntity p where p.ingresoId=:ingresoId")
})
public class IngresoEntity {

    public static final String FIND_ALL_INGRESOS = "findAllIngresos";
    public static final String FIND_INGRESO = "findIngreso";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGRESO_ID", nullable = false)
    private Long ingresoId;

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 150)
    private String descripcion;

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    private Long estado;

    @Basic
    @Column(name = "CREADO_EN", nullable = false)
    private Date creadoEn = new Date();


    public Long getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(Long ingresoId) {
        this.ingresoId = ingresoId;
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

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngresoEntity that = (IngresoEntity) o;

        if (ingresoId != that.ingresoId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

}
