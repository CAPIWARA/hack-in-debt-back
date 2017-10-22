package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficioService {

    @Autowired
    private BeneficioRepository beneficioRepository;
}
