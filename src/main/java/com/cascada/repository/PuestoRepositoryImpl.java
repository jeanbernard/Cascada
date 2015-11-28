package com.cascada.repository;

import com.cascada.domain.PuestoEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return null;
    }

    @Override
    public PuestoEntity findPuesto(Long puestoId) {
        return null;
    }

    @Override
    public PuestoEntity updatePuesto(PuestoEntity puesto) {
        return null;
    }
}
