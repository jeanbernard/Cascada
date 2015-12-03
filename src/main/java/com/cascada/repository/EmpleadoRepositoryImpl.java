package com.cascada.repository;

import com.cascada.domain.EmpleadoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EmpleadoEntity saveEmpleado(EmpleadoEntity empleado) {
        entityManager.persist(empleado);
        entityManager.flush();
        return empleado;
    }

    @Override
    public List<EmpleadoEntity> findAllEmpleados() {
        TypedQuery<EmpleadoEntity> query = entityManager.createNamedQuery(EmpleadoEntity.FIND_ALL_EMPLEADOS, EmpleadoEntity.class);
        return query.getResultList();
    }

    @Override
    public EmpleadoEntity findEmpleado(Long empleadoId) {
        TypedQuery query = entityManager.createNamedQuery(EmpleadoEntity.FIND_EMPLEADO, EmpleadoEntity.class);
        query.setParameter("empleadoId", empleadoId);
        return (EmpleadoEntity) query.getSingleResult();
    }

    @Override
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleado) {
        entityManager.merge(empleado);
        entityManager.flush();
        return empleado;
    }
}
