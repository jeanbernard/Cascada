package com.cascada.service;

import com.cascada.domain.EmpleadoDeduccionEntity;
import com.cascada.domain.IngresoEntity;

import java.util.List;

public interface EmpleadoDeduccionService {
    EmpleadoDeduccionEntity saveEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion, Long empleadoId);

    List<EmpleadoDeduccionEntity> findAllEmpleadoDeduccion();

    EmpleadoDeduccionEntity findEmpleadoDeduccion(Long empleadoDeduccionId);

    EmpleadoDeduccionEntity updateEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion);
}
