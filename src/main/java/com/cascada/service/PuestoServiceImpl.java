package com.cascada.service;

import com.cascada.domain.DepartamentoEntity;
import com.cascada.domain.PuestoEntity;
import com.cascada.repository.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 11/28/15.
 */

@Service
@Transactional
public class PuestoServiceImpl implements PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;


    @Override
    public PuestoEntity savePuesto(PuestoEntity puesto) {
        puesto.setEstado(1L);
        return puestoRepository.savePuesto(puesto);
    }

    @Override
    public List<PuestoEntity> findAllPuestos() {
        return null;
    }

    @Override
    public PuestoEntity findPuesto(Long puestoId) {
        return null;
    }

    @Override
    public PuestoEntity updatePuesto(PuestoEntity puesto) {
        return null;
    }
}