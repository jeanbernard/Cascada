package com.cascada.repository;

import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.EmpleadoDeduccionEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmpleadoDeduccionRepositoryImpl implements EmpleadoDeduccionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EmpleadoDeduccionEntity saveEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion) {
        entityManager.persist(empleadoDeduccion);
        entityManager.flush();
        return empleadoDeduccion;
    }

    @Override
    public List<EmpleadoDeduccionEntity> findAllEmpleadoDeduccions() {
        TypedQuery<EmpleadoDeduccionEntity> query = entityManager.createNamedQuery(EmpleadoDeduccionEntity.FIND_ALL_EMPLEADO_DEDUCCION, EmpleadoDeduccionEntity.class);
        return query.getResultList();
    }

    @Override
    public EmpleadoDeduccionEntity findEmpleadoDeduccion(Long empleadoDeduccionId) {
        TypedQuery query = entityManager.createNamedQuery(EmpleadoDeduccionEntity.FIND_EMPLEADO_DEDUCCION, EmpleadoDeduccionEntity.class);
        query.setParameter("empleadoDeduccionId", empleadoDeduccionId);
        return (EmpleadoDeduccionEntity) query.getSingleResult();
    }

    @Override
    public EmpleadoDeduccionEntity updateEmpleadoDeduccion(EmpleadoDeduccionEntity empleadoDeduccion) {
        entityManager.merge(empleadoDeduccion);
        entityManager.flush();
        return empleadoDeduccion;
    }

}
