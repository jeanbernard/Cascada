package com.cascada.repository;

import com.cascada.domain.NominaEntity;

import java.util.List;

/**
 * Created by jeanbernard on 11/20/15.
 */
public interface NominaRepository {

    NominaEntity saveNomina(NominaEntity nomina);
    List<NominaEntity> findAllNominas();
    NominaEntity findNomina(Long nominaId);
    NominaEntity updateNomina(NominaEntity nomina);

}
