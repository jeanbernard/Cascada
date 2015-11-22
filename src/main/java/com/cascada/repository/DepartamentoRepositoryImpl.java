package com.cascada.repository;

import com.cascada.domain.Departamento;
import com.cascada.domain.DepartamentoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by jeanbernard on 11/20/15.
 */

@Repository
public class DepartamentoRepositoryImpl implements DepartamentoRepository {

@PersistenceContext
private EntityManager entityManager;

    @Override
    public DepartamentoEntity saveDepartamento(DepartamentoEntity departamento) {
        entityManager.persist(departamento);
        entityManager.flush();
        return departamento;
    }
}
