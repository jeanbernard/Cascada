package com.cascada.repository;

import com.cascada.domain.DepartamentoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


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

    @Override
    public List<DepartamentoEntity> findAllDepartments() {
        TypedQuery<DepartamentoEntity> query = entityManager.createNamedQuery(DepartamentoEntity.FIND_ALL_DEPARTMENTS, DepartamentoEntity.class);
        return query.getResultList();
    }

    @Override
    public DepartamentoEntity updateDepartment(DepartamentoEntity departamento) {
        entityManager.merge(departamento);
        entityManager.flush();
        return departamento;
    }

    @Override
    public DepartamentoEntity findDepartment(Long departmentId) {
        TypedQuery query = entityManager.createNamedQuery(DepartamentoEntity.FIND_DEPARTMENT, DepartamentoEntity.class);
        query.setParameter("deptId", departmentId);
        return (DepartamentoEntity) query.getSingleResult();
    }
}
