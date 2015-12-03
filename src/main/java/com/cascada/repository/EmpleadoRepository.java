package com.cascada.repository;

import com.cascada.domain.EmpleadoEntity;

import java.util.List;

/**
 * Created by jeanbernard on 12/2/15.
 */
public interface EmpleadoRepository {
    EmpleadoEntity saveEmpleado(EmpleadoEntity empleado);

    List<EmpleadoEntity> findAllEmpleados();

    EmpleadoEntity findEmpleado(Long empleadoId);

    EmpleadoEntity updateEmpleado(EmpleadoEntity empleado);
}
