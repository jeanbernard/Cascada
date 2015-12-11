package com.cascada.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "DEDUCCION", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=DeduccionEntity.FIND_ALL_DEDUCCIONES, query="Select distinct d from DeduccionEntity d"),
        @NamedQuery(name=DeduccionEntity.FIND_DEDUCCION, query="Select d from DeduccionEntity d where d.deduccionId=:deduccionId")
})
public class DeduccionEntity {

    public static final String FIND_ALL_DEDUCCIONES = "findAlldeducciones";
    public static final String FIND_DEDUCCION = "findDeduccion";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEDUCCION_ID", nullable = false)
    private Long deduccionId;

    @Basic
    @NotNull
    @Size(min=2, max=200, message = "{Size.deduccion.nombre}")
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


    public Long getDeduccionId() {
        return deduccionId;
    }

    public void setDeduccionId(Long deduccionId) {
        this.deduccionId = deduccionId;
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

        DeduccionEntity that = (DeduccionEntity) o;

        if (deduccionId != that.deduccionId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

}
