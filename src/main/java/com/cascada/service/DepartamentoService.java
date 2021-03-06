package com.cascada.service;

import com.cascada.domain.DepartamentoEntity;

import java.util.List;

/**
 * Created by jeanbernard on 11/22/15.
 */
public interface DepartamentoService {
    DepartamentoEntity saveDepartamento(DepartamentoEntity departamento);
    List<DepartamentoEntity> findAllDepartments();
    DepartamentoEntity findDepartment(Long departmentId);
    DepartamentoEntity updateDepartamento(DepartamentoEntity departamento);

}
