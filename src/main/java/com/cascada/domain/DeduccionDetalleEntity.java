package com.cascada.domain;

import javax.persistence.*;

/**
 * Created by jeanbernard on 11/26/15.
 */
@Entity
@Table(name = "DEDUCCION_DETALLE", schema = "Cascada", catalog = "")
public class DeduccionDetalleEntity {
    private int deduccionDetalleId;
    private Integer porcentajeDescuento;

    @Id
    @Column(name = "DEDUCCION_DETALLE_ID", nullable = false)
    public int getDeduccionDetalleId() {
        return deduccionDetalleId;
    }

    public void setDeduccionDetalleId(int deduccionDetalleId) {
        this.deduccionDetalleId = deduccionDetalleId;
    }

    @Basic
    @Column(name = "PORCENTAJE_DESCUENTO", nullable = true)
    public Integer getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeduccionDetalleEntity that = (DeduccionDetalleEntity) o;

        if (deduccionDetalleId != that.deduccionDetalleId) return false;
        if (porcentajeDescuento != null ? !porcentajeDescuento.equals(that.porcentajeDescuento) : that.porcentajeDescuento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deduccionDetalleId;
        result = 31 * result + (porcentajeDescuento != null ? porcentajeDescuento.hashCode() : 0);
        return result;
    }
}
