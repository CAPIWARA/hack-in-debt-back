package br.com.hackindebt.hackindebt.controller;

import br.com.hackindebt.hackindebt.model.Estudante;
import br.com.hackindebt.hackindebt.service.EstudanteService;
import br.com.hackindebt.hackindebt.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class ControllerEstudante {

    @Autowired
    private EstudanteService estudanteService;

    @RequestMapping("/estudante")
    public ResponseEntity saveEstudante(@RequestBody Estudante estudante) {
        LinkedHashMap response = new LinkedHashMap();
        try {
            estudanteService.saveEstudante(estudante);
            response.put("mensagem", Constants.CADASTRO_EFETUADO);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("mensagem", e.getMessage());
            return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
