package com.cascada.repository;

import com.cascada.domain.EmpleadoEntity;
import com.cascada.domain.EmpleadoIngresoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmpleadoIngresoRepositoryImpl implements EmpleadoIngresoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EmpleadoIngresoEntity saveEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso) {
        entityManager.persist(empleadoIngreso);
        entityManager.flush();
        return empleadoIngreso;
    }

    @Override
    public List<EmpleadoIngresoEntity> findAllEmpleadoIngresos() {
        TypedQuery<EmpleadoIngresoEntity> query = entityManager.createNamedQuery(EmpleadoIngresoEntity.FIND_ALL_EMPLEADOS_INGRESOS, EmpleadoIngresoEntity.class);
        return query.getResultList();
    }

    @Override
    public EmpleadoIngresoEntity findEmpleadoIngreso(Long empleadoIngresoId) {
        TypedQuery query = entityManager.createNamedQuery(EmpleadoIngresoEntity.FIND_EMPLEADO_INGRESO, EmpleadoIngresoEntity.class);
        query.setParameter("empleadoIngresoId", empleadoIngresoId);
        return (EmpleadoIngresoEntity) query.getSingleResult();
    }

    @Override
    public EmpleadoIngresoEntity updateEmpleadoIngreso(EmpleadoIngresoEntity empleadoIngreso) {
        entityManager.merge(empleadoIngreso);
        entityManager.flush();
        return empleadoIngreso;
    }

}
