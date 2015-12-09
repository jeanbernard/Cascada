package com.cascada.repository;

import com.cascada.domain.NominaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by jeanbernard on 11/20/15.
 */

@Repository
public class NominaRepositoryImpl implements NominaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public NominaEntity saveNomina(NominaEntity nomina) {
        entityManager.persist(nomina);
        entityManager.flush();
        return nomina;
    }

    @Override
    public List<NominaEntity> findAllNominas() {
        TypedQuery<NominaEntity> query = entityManager.createNamedQuery(NominaEntity.FIND_ALL_NOMINAS, NominaEntity.class);
        return query.getResultList();
    }

    @Override
    public NominaEntity updateNomina(NominaEntity nomina) {
        entityManager.merge(nomina);
        entityManager.flush();
        return nomina;
    }

    @Override
    public NominaEntity findNomina(Long nominaId) {
        TypedQuery query = entityManager.createNamedQuery(NominaEntity.FIND_NOMINA, NominaEntity.class);
        query.setParameter("nominaId", nominaId);
        return (NominaEntity) query.getSingleResult();
    }
}
