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
        return puestoRepository.findAllPuestos();
    }

    @Override
    public PuestoEntity findPuesto(Long puestoId) {
        return puestoRepository.findPuesto(puestoId);
    }

    @Override
    public PuestoEntity updatePuesto(PuestoEntity puesto) {
        return puestoRepository.updatePuesto(puesto);
    }

    @Override
    public List<PuestoEntity> findAllPuestosByDepartmento(Long departamentoId) {
        return puestoRepository.findPuestoByDepartamento(departamentoId);
    }
}
