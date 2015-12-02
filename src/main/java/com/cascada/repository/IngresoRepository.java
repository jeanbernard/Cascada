package com.cascada.repository;

import com.cascada.domain.IngresoEntity;
import com.cascada.domain.PuestoEntity;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */
public interface IngresoRepository {
    IngresoEntity saveIngreso(IngresoEntity ingreso);
    List<IngresoEntity> findAllIngresos();
    IngresoEntity findIngreso(Long ingresoId);
    IngresoEntity updateIngreso(IngresoEntity ingreso);
}
