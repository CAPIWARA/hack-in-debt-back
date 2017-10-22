package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Usuario;
import br.com.hackindebt.hackindebt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDetailsServiceImpl(UsuarioRepository userRepository) {
        this.usuarioRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = usuarioRepository.findByEmail(username);
            if (usuario == null) {
                System.out.println("usuario not found with the provided usuario");
                return null;
            }
            System.out.println("usuario from usuario " + usuario.toString());
            return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuario not found");
        }
    }
}
