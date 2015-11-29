package com.cascada.repository;

import com.cascada.domain.PuestoEntity;
import org.springframework.asm.Type;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by jeanbernard on 11/28/15.
 */

@Repository
public class PuestoRepositoryImpl implements PuestoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PuestoEntity savePuesto(PuestoEntity puesto) {
        entityManager.persist(puesto);
        entityManager.flush();
        return puesto;
    }

    @Override
    public List<PuestoEntity> findAllPuestos() {
        TypedQuery<PuestoEntity> query = entityManager.createNamedQuery(PuestoEntity.FIND_ALL_PUESTOS, PuestoEntity.class);
        return query.getResultList();
    }

    @Override
    public PuestoEntity findPuesto(Long puestoId) {
        TypedQuery query = entityManager.createNamedQuery(PuestoEntity.FIND_PUESTO, PuestoEntity.class);
        query.setParameter("puestoId", puestoId);
        return (PuestoEntity) query.getSingleResult();
    }

    @Override
    public PuestoEntity updatePuesto(PuestoEntity puesto) {
        entityManager.merge(puesto);
        entityManager.flush();
        return puesto;
    }
}
