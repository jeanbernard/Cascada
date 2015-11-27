package com.cascada.domain;

import javax.persistence.*;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "PERIODO", schema = "Cascada", catalog = "")
public class PeriodoEntity {
    private String periodo;
    private String descripcion;

    @Id
    @Column(name = "PERIODO", nullable = false, length = 1)
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodoEntity that = (PeriodoEntity) o;

        if (periodo != null ? !periodo.equals(that.periodo) : that.periodo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = periodo != null ? periodo.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
