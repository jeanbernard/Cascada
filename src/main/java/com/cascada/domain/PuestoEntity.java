package com.cascada.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "PUESTO", schema = "Cascada", catalog = "")
public class PuestoEntity {
    private int puestoId;
    private String nombre;
    private String descripcion;
    private BigInteger estado;
    private Serializable creadoEn;

    @Id
    @Column(name = "PUESTO_ID", nullable = false)
    public int getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(int puestoId) {
        this.puestoId = puestoId;
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
    @Column(name = "DESCRIPCION", nullable = true, length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "CREADO_EN", nullable = false)
    public Serializable getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Serializable creadoEn) {
        this.creadoEn = creadoEn;
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

    @Override
    public int hashCode() {
        int result = puestoId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (creadoEn != null ? creadoEn.hashCode() : 0);
        return result;
    }
}
