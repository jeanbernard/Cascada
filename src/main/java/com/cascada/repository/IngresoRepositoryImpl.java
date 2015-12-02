package com.cascada.repository;

import com.cascada.domain.IngresoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Repository
public class IngresoRepositoryImpl implements IngresoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public IngresoEntity saveIngreso(IngresoEntity ingreso) {
        entityManager.persist(ingreso);
        entityManager.flush();
        return ingreso;
    }

    @Override
    public List<IngresoEntity> findAllIngresos() {
        TypedQuery<IngresoEntity> query = entityManager.createNamedQuery(IngresoEntity.FIND_ALL_INGRESOS, IngresoEntity.class);
        return query.getResultList();
    }

    @Override
    public IngresoEntity findIngreso(Long ingresoId) {
        TypedQuery query = entityManager.createNamedQuery(IngresoEntity.FIND_INGRESO, IngresoEntity.class);
        query.setParameter("ingresoId", ingresoId);
        return (IngresoEntity) query.getSingleResult();
    }

    @Override
    public IngresoEntity updateIngreso(IngresoEntity ingreso) {
        entityManager.merge(ingreso);
        entityManager.flush();
        return ingreso;
    }
}
