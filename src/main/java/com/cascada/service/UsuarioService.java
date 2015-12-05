package com.cascada.service;

import com.cascada.domain.UsuarioEntity;
import org.hibernate.NonUniqueResultException;

import javax.persistence.NoResultException;
import java.util.HashMap;

/**
 * Created by Jalissa on 12/5/2015.
 */
public interface UsuarioService {

    HashMap<String, Object> loginUsuario (UsuarioEntity usuario);
    boolean isCampoUsuarioValido(UsuarioEntity usuario);
}
