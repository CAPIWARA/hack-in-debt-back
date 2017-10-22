package br.com.hackindebt.hackindebt.controller;

import br.com.hackindebt.hackindebt.model.Instituicao;
import br.com.hackindebt.hackindebt.service.InstituicaoService;
import br.com.hackindebt.hackindebt.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class ControllerInstituicao {

    @Autowired
    private InstituicaoService instituicaoService;

    @RequestMapping(value = "/instituicao", method = RequestMethod.POST)
    public ResponseEntity<?> saveEmpresa(@RequestBody Instituicao instituicao) {
        System.out.println("Comecamos por aquix: " + instituicao.toString());
        LinkedHashMap response = new LinkedHashMap();
        try {
            instituicaoService.saveInstituicao(instituicao);
            response.put("message", Constants.CADASTRO_EFETUADO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
