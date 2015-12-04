package com.cascada.service;

import com.cascada.domain.EmpleadoIngresoEntity;

import java.util.List;

public interface EmpleadoIngresoService {
    EmpleadoIngresoEntity saveEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso, Long empleadoId);

    List<EmpleadoIngresoEntity> findAllEmpleadoIngresos();

    EmpleadoIngresoEntity findEmpleadoIngreso(Long empleadoIngresoId);

    EmpleadoIngresoEntity updateEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso);
}
