package com.cascada.service;

import com.cascada.domain.UsuarioEntity;
import com.cascada.repository.UsuarioRepository;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jalissa on 12/5/2015.
 */
public class UsuarioServiceImpl implements UsuarioService {
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public HashMap<String, Object> loginUsuario(UsuarioEntity usuario) {
        HashMap map = new HashMap();
        ArrayList<String> errors = new ArrayList<String>();
        try{
            UsuarioEntity loggedUsuario = usuarioRepository.loginUsuario(usuario);
            if(loggedUsuario != null){
                map.put("logged", true);
            }
        }catch(NoResultException noResult){
            errors.add("Usuario / contraseña inválido.");
        }catch (NonUniqueResultException noUnique){
            errors.add("Existe más de un usuario con estas credenciales.");
        }
        map.put("errors",errors );
        return map;
    }

    public boolean isCampoUsuarioValido(UsuarioEntity usuario){
        String nombreUsuario = usuario.getNombreUsuario();
        String clave = usuario.getClave();

        if(nombreUsuario == null || nombreUsuario.isEmpty() || !nombreUsuario.matches(EMAIL_REGEX)
                || clave == null || clave.isEmpty()){
            return false;
        }

        return true;

    }
}
