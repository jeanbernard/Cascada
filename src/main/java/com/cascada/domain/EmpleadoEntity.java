package com.cascada.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "EMPLEADO", schema = "Cascada", catalog = "")
public class EmpleadoEntity {
    private int empleadoId;
    private String nombres;
    private String apellidos;
    private String correo;
    private Date fechaIngreso;
    private BigInteger estado;
    private Date creadoEn;

    @Id
    @Column(name = "EMPLEADO_ID", nullable = false)
    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Basic
    @Column(name = "NOMBRES", nullable = false, length = 200)
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 200)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "CORREO", nullable = true, length = 100)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "FECHA_INGRESO", nullable = false)
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (empleadoId != that.empleadoId) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (fechaIngreso != null ? !fechaIngreso.equals(that.fechaIngreso) : that.fechaIngreso != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (creadoEn != null ? !creadoEn.equals(that.creadoEn) : that.creadoEn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empleadoId;
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (fechaIngreso != null ? fechaIngreso.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (creadoEn != null ? creadoEn.hashCode() : 0);
        return result;
    }
}
