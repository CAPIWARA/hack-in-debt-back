package br.com.hackindebt.hackindebt.controller;

import br.com.hackindebt.hackindebt.service.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBeneficio {

    @Autowired
    private BeneficioService beneficioService;

}
