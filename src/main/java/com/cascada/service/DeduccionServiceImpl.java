package com.cascada.service;

import com.cascada.domain.DeduccionEntity;
import com.cascada.repository.DeduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jeanbernard on 12/1/15.
 */

@Service
@Transactional
public class DeduccionServiceImpl implements DeduccionService {

    @Autowired
    private DeduccionRepository deduccionRepository;


    @Override
    public DeduccionEntity saveDeduccion(DeduccionEntity deduccion) {
        deduccion.setEstado(1L);
        return deduccionRepository.saveDeduccion(deduccion);
    }

    @Override
    public List<DeduccionEntity> findAllDeduccions() {
        return deduccionRepository.findAllDeducciones();
    }

    @Override
    public DeduccionEntity findDeduccion(Long deduccionId) {
        return deduccionRepository.findDeduccion(deduccionId);
    }

    @Override
    public DeduccionEntity updateDeduccion(DeduccionEntity deduccion) {
        return deduccionRepository.updateDeduccion(deduccion);
    }
}
