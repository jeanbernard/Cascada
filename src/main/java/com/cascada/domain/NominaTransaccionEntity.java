package com.cascada.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "NOMINA_TRANSACCION", schema = "Cascada", catalog = "")
public class NominaTransaccionEntity {
    private int nominaTransaccionId;
    private int empleadoId;
    private int monto;
    private Date fecha;
    private String estatus;

    @Id
    @Column(name = "NOMINA_TRANSACCION_ID", nullable = false)
    public int getNominaTransaccionId() {
        return nominaTransaccionId;
    }

    public void setNominaTransaccionId(int nominaTransaccionId) {
        this.nominaTransaccionId = nominaTransaccionId;
    }

    @Basic
    @Column(name = "EMPLEADO_ID", nullable = false)
    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Basic
    @Column(name = "MONTO", nullable = false, precision = 0)
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Basic
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "ESTATUS", nullable = false, length = 1)
    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NominaTransaccionEntity that = (NominaTransaccionEntity) o;

        if (nominaTransaccionId != that.nominaTransaccionId) return false;
        if (empleadoId != that.empleadoId) return false;
        if (monto != that.monto) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (estatus != null ? !estatus.equals(that.estatus) : that.estatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nominaTransaccionId;
        result = 31 * result + empleadoId;
        result = 31 * result + monto;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estatus != null ? estatus.hashCode() : 0);
        return result;
    }
}
