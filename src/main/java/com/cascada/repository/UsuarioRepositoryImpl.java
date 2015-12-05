package com.cascada.repository;

import com.cascada.domain.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by Jalissa on 12/5/2015.
 */
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UsuarioEntity loginUsuario(UsuarioEntity usuario) {
        TypedQuery query = entityManager.createNamedQuery(UsuarioEntity.LOGIN_USUARIO, UsuarioEntity.class);
        query.setParameter("nombreUsuario", usuario.getNombreUsuario());
        query.setParameter("clave", usuario.getClave());
        return (UsuarioEntity) query.getSingleResult();
    }
}
