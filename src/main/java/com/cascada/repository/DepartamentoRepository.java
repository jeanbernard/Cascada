package com.cascada.repository;

import com.cascada.domain.Departamento;
import com.cascada.domain.DepartamentoEntity;

import java.util.List;

/**
 * Created by jeanbernard on 11/20/15.
 */
public interface DepartamentoRepository {

    DepartamentoEntity saveDepartamento(DepartamentoEntity departamento);
    List<DepartamentoEntity> findAllDepartments();

}
