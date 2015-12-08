package com.cascada.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "EMPLEADO_DEDUCCION", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=EmpleadoDeduccionEntity.FIND_ALL_EMPLEADO_DEDUCCION, query="Select distinct p from EmpleadoDeduccionEntity p"),
        @NamedQuery(name=EmpleadoDeduccionEntity.FIND_EMPLEADO_DEDUCCION, query="Select p from EmpleadoDeduccionEntity p where p.empleadoId=:empleadoId")
})
public class EmpleadoDeduccionEntity {

    public static final String FIND_ALL_EMPLEADO_DEDUCCION = "findAllEmpleadosDeducciones";
    public static final String FIND_EMPLEADO_DEDUCCION = "findEmpleadoDeducciones";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLEADO_DEDUCCION_ID", nullable = false)
    private int empleadoDeduccionId;

    @Basic
    @Column(name = "MONTO", nullable = false, precision = 0)
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name="EMPLEADO_ID", nullable = false,
            foreignKey = @ForeignKey(name = "EMPLEADO_ID_FK"))
    private EmpleadoEntity empleadoId;


    @ManyToOne
    @JoinColumn(name = "DEDUCCION_ID", nullable = false,
            foreignKey = @ForeignKey(name = "DEDUCCION_ID_FK"))
    private DeduccionEntity deduccionId;


    public int getEmpleadoDeduccionId() {
        return empleadoDeduccionId;
    }

    public void setEmpleadoDeduccionId(int empleadoDeduccionId) {
        this.empleadoDeduccionId = empleadoDeduccionId;
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

    public DeduccionEntity getDeduccionId() {
        return deduccionId;
    }

    public void setDeduccionId(DeduccionEntity deduccionId) {
        this.deduccionId = deduccionId;
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

}
