package com.cascada.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "EMPLEADO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=EmpleadoEntity.FIND_ALL_EMPLEADOS, query="Select distinct p from EmpleadoEntity p"),
        @NamedQuery(name=EmpleadoEntity.FIND_EMPLEADO, query="Select p from EmpleadoEntity p where p.empleadoId=:empleadoId")
})
public class EmpleadoEntity {

    public static final String FIND_ALL_EMPLEADOS = "findAllEmpleados";
    public static final String FIND_EMPLEADO = "findEmpleado";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLEADO_ID", nullable = false)
    private Long empleadoId;

    @Basic
    @Column(name = "NOMBRES", nullable = false, length = 100)
    private String nombres;

    @Basic
    @Column(name = "APELLIDOS", nullable = true, length = 150)
    private String apellidos;

    @Basic
    @Column(name = "CORREO", nullable = true, length = 150)
    private String correo;

    @Basic
    @Column(name = "ESTADO", nullable = false, precision = 0)
    private Long estado;

    @Basic
    @Column(name = "FECHA_INGRESO", nullable = false)
    private Date fechaIngreso = new Date();

    @Basic
    @Column(name = "CREADO_EN", nullable = false)
    private Date creadoEn = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PUESTO_ID", nullable = false,
            foreignKey = @ForeignKey(name = "PUESTO_ID_FK"))
    private PuestoEntity puestoEntity;

    @OneToMany(mappedBy = "empleadoId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmpleadoIngresoEntity> empleadoIngreso = new ArrayList<EmpleadoIngresoEntity>();

    @OneToMany(mappedBy = "empleadoId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmpleadoDeduccionEntity> empleadoDeduccion = new ArrayList<EmpleadoDeduccionEntity>();


    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String descripcion) {
        this.apellidos = descripcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public PuestoEntity getPuestoEntity() {
        return puestoEntity;
    }

    public void setPuestoEntity(PuestoEntity empleadoEntity) {
        this.puestoEntity = empleadoEntity;
    }

    public List<EmpleadoIngresoEntity> getEmpleadoIngreso() {
        return empleadoIngreso;
    }

    public void setEmpleadoIngreso(List<EmpleadoIngresoEntity> empleados) {
        this.empleadoIngreso = empleados;
    }

    public List<EmpleadoDeduccionEntity> getEmpleadoDeduccion() {
        return empleadoDeduccion;
    }

    public void setEmpleadoDeduccion(List<EmpleadoDeduccionEntity> empleadoDeduccion) {
        this.empleadoDeduccion = empleadoDeduccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadoEntity that = (EmpleadoEntity) o;

        if (empleadoId != that.empleadoId) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

}
