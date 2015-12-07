package com.cascada.service;

import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.EmpleadoIngresoEntity;
import com.cascada.domain.IngresoEntity;
import com.cascada.repository.EmpleadoIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    public EmpleadoIngresoEntity saveEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso, Long empleadoId) {
        //empleadoIngreso.setMonto(new BigDecimal(1000));

        IngresoEntity ingresoEntity = new IngresoEntity();
        ingresoEntity.setEstado(1L);


        EmpleadoEntity empleadoCreado = new EmpleadoEntity();
        empleadoCreado.setEmpleadoId(empleadoId);
        empleadoIngreso.setEmpleadoId(empleadoCreado);
        empleadoIngreso.setIngresoId(ingresoEntity);
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
