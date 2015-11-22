package com.cascada.repository;

import com.cascada.domain.Departamento;

/**
 * Created by jeanbernard on 11/20/15.
 */
public class DepartamentoRepositoryImpl implements DepartamentoRepository {


    @Override
    public Departamento saveDepartment() {

        Departamento departamento = new Departamento();
        departamento.setNombre("Factoria");
        departamento.setDescripcion("Factoria de Software");

        return departamento;
    }
}
