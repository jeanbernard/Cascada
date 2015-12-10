package com.cascada.service;

import com.cascada.domain.NominaEntity;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */
public interface NominaService {
    NominaEntity saveNomina(NominaEntity nomina);
    List<NominaEntity> findAllNominas();
    NominaEntity findNomina(Long nominaId);
    NominaEntity updateNomina(NominaEntity nomina);
}
