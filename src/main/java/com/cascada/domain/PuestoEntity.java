package com.cascada.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "PUESTO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=PuestoEntity.FIND_ALL_PUESTOS, query="Select distinct p from PuestoEntity p"),
        @NamedQuery(name=PuestoEntity.FIND_PUESTO, query="Select p from PuestoEntity p where p.puestoId=:puestoId"),
        @NamedQuery(name=PuestoEntity.FIND_PUESTO_BY_DEPARTAMENTO, query="Select p from PuestoEntity p where p.departamentoEntity.departamentoId=:departamentoId")
})
public class PuestoEntity {

    public static final String FIND_ALL_PUESTOS = "findAllPuestos";
    public static final String FIND_PUESTO = "findPuesto";
    public static final String FIND_PUESTO_BY_DEPARTAMENTO = "findPuestoByDepartamento";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PUESTO_ID", nullable = false)
    private Long puestoId;

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 200)
    private String descripcion;

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    private Long estado;

    @Basic
    @Column(name = "CREADO_EN", nullable = false)
    private Date creadoEn = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTAMENTO_ID", nullable = false,
            foreignKey = @ForeignKey(name = "DEPARTAMENTO_ID_FK"))
    private DepartamentoEntity departamentoEntity;

    @OneToMany(mappedBy = "puestoEntity", cascade = CascadeType.ALL)
    private List<EmpleadoEntity> empleados = new ArrayList<EmpleadoEntity>();

    public Long getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(Long puestoId) {
        this.puestoId = puestoId;
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

    public Serializable getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }


    public DepartamentoEntity getDepartamentoEntity() {
        return departamentoEntity;
    }

    public void setDepartamentoEntity(DepartamentoEntity departamento) {
        this.departamentoEntity = departamento;
    }

    @JsonIgnore
    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PuestoEntity that = (PuestoEntity) o;

        if (puestoId != that.puestoId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (creadoEn != null ? !creadoEn.equals(that.creadoEn) : that.creadoEn != null) return false;

        return true;
    }

}
