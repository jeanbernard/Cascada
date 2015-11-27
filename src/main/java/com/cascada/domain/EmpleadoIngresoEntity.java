package com.cascada.domain;

import javax.persistence.*;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "EMPLEADO_INGRESO", schema = "Cascada", catalog = "")
public class EmpleadoIngresoEntity {
    private int empleadoIngresoId;
    private int monto;

    @Id
    @Column(name = "EMPLEADO_INGRESO_ID", nullable = false)
    public int getEmpleadoIngresoId() {
        return empleadoIngresoId;
    }

    public void setEmpleadoIngresoId(int empleadoIngresoId) {
        this.empleadoIngresoId = empleadoIngresoId;
    }

    @Basic
    @Column(name = "MONTO", nullable = false, precision = 0)
    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoIngresoEntity that = (EmpleadoIngresoEntity) o;

        if (empleadoIngresoId != that.empleadoIngresoId) return false;
        if (monto != that.monto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empleadoIngresoId;
        result = 31 * result + monto;
        return result;
    }
}
