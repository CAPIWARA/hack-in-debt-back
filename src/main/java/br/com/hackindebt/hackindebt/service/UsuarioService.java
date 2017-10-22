package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Login;
import br.com.hackindebt.hackindebt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Login findByEmail(String email) {
        List<Login> list = usuarioRepository.findByEmail(email);
        if (list.size() > 0) return list.get(0);
        return null;
    }

}
