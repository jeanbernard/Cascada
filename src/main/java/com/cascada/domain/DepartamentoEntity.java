package com.cascada.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "DEPARTAMENTO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=DepartamentoEntity.FIND_ALL_DEPARTMENTS, query="Select distinct d from DepartamentoEntity d"),
        @NamedQuery(name=DepartamentoEntity.FIND_DEPARTMENT, query="Select d from DepartamentoEntity d where d.departamentoId=:deptId")
})
public class DepartamentoEntity {

    public static final String FIND_ALL_DEPARTMENTS = "findAllDepartments";
    public static final String FIND_DEPARTMENT = "findDepartment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTAMENTO_ID", nullable = false)
    private Long departamentoId;

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 150)
    private String descripcion;

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    private Long estado;

    @OneToMany(mappedBy = "departamentoEntity", cascade = CascadeType.ALL)
    private List<PuestoEntity> puestos = new ArrayList<PuestoEntity>();


    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
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

    @JsonIgnore
    public List<PuestoEntity> getPuestos() {
        return puestos;
    }

    public void setPuestos(List<PuestoEntity> puestos) {
        this.puestos = puestos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartamentoEntity that = (DepartamentoEntity) o;

        if (departamentoId != that.departamentoId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }
}
