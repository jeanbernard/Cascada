package com.cascada.domain;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "DEDUCCION", schema = "Cascada", catalog = "")
public class DeduccionEntity {
    private int deduccionId;
    private String nombre;
    private String descripcion;
    private BigInteger estado;

    @Id
    @Column(name = "DEDUCCION_ID", nullable = false)
    public int getDeduccionId() {
        return deduccionId;
    }

    public void setDeduccionId(int deduccionId) {
        this.deduccionId = deduccionId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 45)
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

    @Override
    public int hashCode() {
        int result = deduccionId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
