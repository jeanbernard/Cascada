package com.cascada.service;

import com.cascada.domain.DepartamentoEntity;
import com.cascada.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

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
        departamento.setEstado(1L);
        return departamentoRepository.saveDepartamento(departamento);
    }

    @Override
    public List<DepartamentoEntity> findAllDepartments() {
        return departamentoRepository.findAllDepartments();
    }
}
