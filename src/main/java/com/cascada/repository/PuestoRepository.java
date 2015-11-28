package com.cascada.repository;

import com.cascada.domain.PuestoEntity;

import java.util.List;

/**
 * Created by jeanbernard on 11/28/15.
 */
public interface PuestoRepository {
    PuestoEntity savePuesto(PuestoEntity puesto);
    List<PuestoEntity> findAllPuestos();
    PuestoEntity findPuesto(Long puestoId);
    PuestoEntity updatePuesto(PuestoEntity puesto);
}
