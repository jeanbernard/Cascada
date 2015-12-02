package com.cascada.service;

import com.cascada.domain.IngresoEntity;
import com.cascada.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Service
@Transactional
public class IngresoServiceImpl implements IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;


    @Override
    public IngresoEntity saveIngreso(IngresoEntity ingreso) {
        ingreso.setEstado(1L);
        return ingresoRepository.saveIngreso(ingreso);
    }

    @Override
    public List<IngresoEntity> findAllIngresos() {
        return ingresoRepository.findAllIngresos();
    }

    @Override
    public IngresoEntity findIngreso(Long ingresoId) {
        return ingresoRepository.findIngreso(ingresoId);
    }

    @Override
    public IngresoEntity updateIngreso(IngresoEntity ingreso) {
        return ingresoRepository.updateIngreso(ingreso);
    }
}
