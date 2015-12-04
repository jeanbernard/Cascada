package com.cascada.repository;

import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.EmpleadoIngresoEntity;

import java.util.List;

public interface EmpleadoIngresoRepository {
    EmpleadoIngresoEntity saveEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso);

    List<EmpleadoIngresoEntity> findAllEmpleadoIngresos();

    EmpleadoIngresoEntity findEmpleadoIngreso(Long empleadoIngresoId);

    EmpleadoIngresoEntity updateEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso);
}
