package com.cascada.repository;

import com.cascada.domain.Departamento;
import com.cascada.domain.DepartamentoEntity;

/**
 * Created by jeanbernard on 11/20/15.
 */
public interface DepartamentoRepository {

    DepartamentoEntity saveDepartamento(DepartamentoEntity departamento);

}
