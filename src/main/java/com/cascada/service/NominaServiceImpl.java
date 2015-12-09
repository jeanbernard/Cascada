package com.cascada.service;

import com.cascada.domain.NominaEntity;
import com.cascada.repository.NominaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Service
@Transactional
public class NominaServiceImpl implements NominaService {

    @Autowired
    private NominaRepository nominaRepository;


    @Override
    public NominaEntity saveNomina(NominaEntity nomina) {
        nomina.setEstado(1L);
        return nominaRepository.saveNomina(nomina);
    }

    @Override
    public List<NominaEntity> findAllNominas() {
        return nominaRepository.findAllNominas();
    }

    @Override
    public NominaEntity findNomina(Long nominaId) {
        return nominaRepository.findNomina(nominaId);
    }

    @Override
    public NominaEntity updateNomina(NominaEntity nomina) {
        nomina.setEstado(1L);
        return nominaRepository.updateNomina(nomina);
    }
}
