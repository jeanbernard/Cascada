package com.cascada.service;

import com.cascada.domain.DeduccionEntity;
import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.EmpleadoDeduccionEntity;
import com.cascada.domain.IngresoEntity;
import com.cascada.repository.EmpleadoDeduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Service
@Transactional
public class EmpleadoDeduccionServiceImpl implements EmpleadoDeduccionService {

    @Autowired
    private EmpleadoDeduccionRepository empleadoDeduccionRepository;


    @Override
    public EmpleadoDeduccionEntity saveEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion, Long empleadoId) {

        DeduccionEntity deduccionEntity = new DeduccionEntity();
        deduccionEntity.setEstado(1L);

        EmpleadoEntity empleadoCreado = new EmpleadoEntity();
        empleadoCreado.setEmpleadoId(empleadoId);
        empleadoDeduccion.setEmpleadoId(empleadoCreado);
        empleadoDeduccion.setDeduccionId(deduccionEntity);
        return empleadoDeduccionRepository.saveEmpleadoDeduccion(empleadoDeduccion);
    }

    @Override
    public List<EmpleadoDeduccionEntity> findAllEmpleadoDeduccion() {
        return empleadoDeduccionRepository.findAllEmpleadoDeduccions();
    }

    @Override
    public EmpleadoDeduccionEntity findEmpleadoDeduccion(Long empleadoDeduccionId) {
        return empleadoDeduccionRepository.findEmpleadoDeduccion(empleadoDeduccionId);
    }

    @Override
    public EmpleadoDeduccionEntity updateEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion) {
        return empleadoDeduccionRepository.updateEmpleadoDeduccion(empleadoDeduccion);
    }
}
