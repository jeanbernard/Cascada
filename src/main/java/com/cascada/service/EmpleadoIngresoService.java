package com.cascada.service;

import com.cascada.domain.EmpleadoIngresoEntity;
import com.cascada.domain.IngresoEntity;

import java.util.List;

public interface EmpleadoIngresoService {
    EmpleadoIngresoEntity saveEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso, Long empleadoId, IngresoEntity ingresoEntity);

    List<EmpleadoIngresoEntity> findAllEmpleadoIngresos();

    EmpleadoIngresoEntity findEmpleadoIngreso(Long empleadoIngresoId);

    EmpleadoIngresoEntity updateEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso);
}
