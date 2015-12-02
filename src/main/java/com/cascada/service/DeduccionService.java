package com.cascada.service;

import com.cascada.domain.DeduccionEntity;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */
public interface DeduccionService {
    DeduccionEntity saveDeduccion(DeduccionEntity deduccion);
    List<DeduccionEntity> findAllDeducciones();
    DeduccionEntity findDeduccion(Long deduccionId);
    DeduccionEntity updateDeduccion(DeduccionEntity deduccion);
}

