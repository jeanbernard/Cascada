package com.cascada.domain;

import javax.persistence.*;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "NOMINA", schema = "Cascada", catalog = "")
public class NominaEntity {
    private int nominaId;
    private String nombre;
    private String descripcion;
    private int estado;

    @Id
    @Column(name = "NOMINA_ID", nullable = false)
    public int getNominaId() {
        return nominaId;
    }

    public void setNominaId(int nominaId) {
        this.nominaId = nominaId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 150)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false)
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
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

    @Override
    public int hashCode() {
        int result = nominaId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }
}
