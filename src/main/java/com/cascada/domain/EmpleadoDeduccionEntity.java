package com.cascada.domain;

import javax.persistence.*;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "EMPLEADO_DEDUCCION", schema = "Cascada", catalog = "")
public class EmpleadoDeduccionEntity {
    private int empleadoDeduccionId;
    private int monto;

    @Id
    @Column(name = "EMPLEADO_DEDUCCION_ID", nullable = false)
    public int getEmpleadoDeduccionId() {
        return empleadoDeduccionId;
    }

    public void setEmpleadoDeduccionId(int empleadoDeduccionId) {
        this.empleadoDeduccionId = empleadoDeduccionId;
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

        EmpleadoDeduccionEntity that = (EmpleadoDeduccionEntity) o;

        if (empleadoDeduccionId != that.empleadoDeduccionId) return false;
        if (monto != that.monto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empleadoDeduccionId;
        result = 31 * result + monto;
        return result;
    }
}
