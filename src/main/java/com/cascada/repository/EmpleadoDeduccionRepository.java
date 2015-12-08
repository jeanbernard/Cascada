package com.cascada.repository;

import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.EmpleadoDeduccionEntity;
import com.cascada.domain.IngresoEntity;

import java.util.List;

public interface EmpleadoDeduccionRepository {
    EmpleadoDeduccionEntity saveEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion);

    List<EmpleadoDeduccionEntity> findAllEmpleadoDeduccions();

    EmpleadoDeduccionEntity findEmpleadoDeduccion(Long empleadoDeduccionId);

    EmpleadoDeduccionEntity updateEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion);
}
