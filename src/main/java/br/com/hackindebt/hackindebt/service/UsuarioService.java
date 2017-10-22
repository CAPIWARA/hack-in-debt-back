package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Usuario;
import br.com.hackindebt.hackindebt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findEmpresaByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
