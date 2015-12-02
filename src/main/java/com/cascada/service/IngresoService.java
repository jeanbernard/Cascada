package com.cascada.service;

import com.cascada.domain.IngresoEntity;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */
public interface IngresoService {
    IngresoEntity saveIngreso(IngresoEntity ingreso);
    List<IngresoEntity> findAllIngresos();
    IngresoEntity findIngreso(Long ingresoId);
    IngresoEntity updateIngreso(IngresoEntity ingreso);
}
