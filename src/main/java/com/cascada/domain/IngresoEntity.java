package com.cascada.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "INGRESO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=IngresoEntity.FIND_ALL_INGRESOS, query="Select distinct p from IngresoEntity p"),
        @NamedQuery(name=IngresoEntity.FIND_INGRESO, query="Select p from IngresoEntity p where p.ingresoId=:ingresoId")
})
public class IngresoEntity implements Serializable {

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

    @OneToMany(mappedBy = "ingresoId", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EmpleadoIngresoEntity> ingresos = new ArrayList<EmpleadoIngresoEntity>();


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

    public List<EmpleadoIngresoEntity> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<EmpleadoIngresoEntity> ingresos) {
        this.ingresos = ingresos;
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
