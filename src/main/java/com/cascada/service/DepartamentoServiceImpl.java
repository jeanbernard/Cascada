package com.cascada.service;

import com.cascada.domain.Departamento;
import com.cascada.domain.DepartamentoEntity;
import com.cascada.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 * Created by jeanbernard on 11/22/15.
 */

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

@Autowired
private DepartamentoRepository departamentoRepository;

    @Override
    @Transactional
    public DepartamentoEntity saveDepartamento(DepartamentoEntity departamento) {
        departamento.setEstado(new BigInteger(String.valueOf(1)));
        return departamentoRepository.saveDepartamento(departamento);
    }
}
