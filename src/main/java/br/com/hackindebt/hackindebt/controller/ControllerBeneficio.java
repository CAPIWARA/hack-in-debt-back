package br.com.hackindebt.hackindebt.controller;

import br.com.hackindebt.hackindebt.service.BeneficioService;
import br.com.hackindebt.hackindebt.service.EstudanteService;
import br.com.hackindebt.hackindebt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class ControllerBeneficio {

    @Autowired
    private BeneficioService beneficioService;

    @RequestMapping(value = "/beneficio")
    public ResponseEntity listarBeneficios() {
        LinkedHashMap response = new LinkedHashMap();
        try {
            return new ResponseEntity(beneficioService.findByAtivoTrue(), HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Não foi encontrado nenhum beneficio");
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/resgatarbeneficio/{idbeneficio}/{email}/")
    public String resgatarBeneficio(
            @RequestParam("idbeneficio") Long idbeneficio,
            @RequestParam("email") String email) {
        try {
            if(beneficioService.resgatarBeneficio(idbeneficio, email));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "alo";
    }
}
