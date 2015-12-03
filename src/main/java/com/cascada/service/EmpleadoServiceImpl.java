package com.cascada.service;

import com.cascada.domain.EmpleadoEntity;
import com.cascada.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public EmpleadoEntity saveEmpleado(EmpleadoEntity empleado) {
        empleado.setEstado(1L);
        return empleadoRepository.saveEmpleado(empleado);
    }

    @Override
    public List<EmpleadoEntity> findAllEmpleados() {
        return empleadoRepository.findAllEmpleados();
    }

    @Override
    public EmpleadoEntity findEmpleado(Long empleadoId) {
        return empleadoRepository.findEmpleado(empleadoId);
    }

    @Override
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado) {
        return empleadoRepository.updateEmpleado(empleado);
    }
}
