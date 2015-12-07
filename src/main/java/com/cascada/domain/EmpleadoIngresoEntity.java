package com.cascada.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "EMPLEADO_INGRESO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=EmpleadoIngresoEntity.FIND_ALL_EMPLEADOS_INGRESOS, query="Select distinct p from EmpleadoIngresoEntity p"),
        @NamedQuery(name=EmpleadoIngresoEntity.FIND_EMPLEADO_INGRESO, query="Select p from EmpleadoIngresoEntity p where p.empleadoId=:empleadoId")
})
public class EmpleadoIngresoEntity {

    public static final String FIND_ALL_EMPLEADOS_INGRESOS = "findAllEmpleadosIngresos";
    public static final String FIND_EMPLEADO_INGRESO = "findEmpleadoIngresos";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLEADO_INGRESO_ID", nullable = false)
    private int empleadoIngresoId;

    @Basic
    @Column(name = "MONTO", nullable = false, precision = 0)
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name="EMPLEADO_ID", nullable = false,
            foreignKey = @ForeignKey(name = "EMPLEADO_ID_FK"))
    private EmpleadoEntity empleadoId;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INGRESO_ID", nullable = false,
            foreignKey = @ForeignKey(name = "INGRESO_ID_FK"))
    private IngresoEntity ingresoId;


    public int getEmpleadoIngresoId() {
        return empleadoIngresoId;
    }

    public void setEmpleadoIngresoId(int empleadoIngresoId) {
        this.empleadoIngresoId = empleadoIngresoId;
    }


    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public EmpleadoEntity getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(EmpleadoEntity empleadoId) {
        this.empleadoId = empleadoId;
    }

    public IngresoEntity getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(IngresoEntity ingresoId) {
        this.ingresoId = ingresoId;
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

}
