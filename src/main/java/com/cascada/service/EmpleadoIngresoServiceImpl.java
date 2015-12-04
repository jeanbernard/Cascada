package com.cascada.service;

import com.cascada.domain.EmpleadoIngresoEntity;
import com.cascada.repository.EmpleadoIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Service
@Transactional
public class EmpleadoIngresoServiceImpl implements EmpleadoIngresoService {

    @Autowired
    private EmpleadoIngresoRepository empleadoIngresoRepository;


    @Override
    public EmpleadoIngresoEntity saveEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso) {
        //empleadoIngreso.setEstado(1L);
        return empleadoIngresoRepository.saveEmpleadoIngreso(empleadoIngreso);
    }

    @Override
    public List<EmpleadoIngresoEntity> findAllEmpleadoIngresos() {
        return empleadoIngresoRepository.findAllEmpleadoIngresos();
    }

    @Override
    public EmpleadoIngresoEntity findEmpleadoIngreso(Long empleadoIngresoId) {
        return empleadoIngresoRepository.findEmpleadoIngreso(empleadoIngresoId);
    }

    @Override
    public EmpleadoIngresoEntity updateEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso) {
        return empleadoIngresoRepository.updateEmpleadoIngreso(empleadoIngreso);
    }
}
