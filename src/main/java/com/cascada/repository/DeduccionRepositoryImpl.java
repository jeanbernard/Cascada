package com.cascada.repository;

import com.cascada.domain.DeduccionEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Repository
public class DeduccionRepositoryImpl implements DeduccionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DeduccionEntity saveDeduccion(DeduccionEntity deduccion) {
        entityManager.persist(deduccion);
        entityManager.flush();
        return deduccion;
    }

    @Override
    public List<DeduccionEntity> findAllDeducciones() {
        TypedQuery<DeduccionEntity> query = entityManager.createNamedQuery(DeduccionEntity.FIND_ALL_DEDUCCIONES, DeduccionEntity.class);
        return query.getResultList();
    }

    @Override
    public DeduccionEntity findDeduccion(Long deduccionId) {
        TypedQuery query = entityManager.createNamedQuery(DeduccionEntity.FIND_DEDUCCION, DeduccionEntity.class);
        query.setParameter("deduccionId", deduccionId);
        return (DeduccionEntity) query.getSingleResult();
    }

    @Override
    public DeduccionEntity updateDeduccion(DeduccionEntity deduccion) {
        entityManager.merge(deduccion);
        entityManager.flush();
        return deduccion;
    }
}
