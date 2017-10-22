package br.com.hackindebt.hackindebt.controller;

import br.com.hackindebt.hackindebt.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
public class ControllerMonitor {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String monitor() {
        long localDate = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        //return String.valueOf(localDate);
        return usuarioService.findByEmail("capiwara@gmail.com").toString();
    }

    @RequestMapping("/users")
    public @ResponseBody
    String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }
}
