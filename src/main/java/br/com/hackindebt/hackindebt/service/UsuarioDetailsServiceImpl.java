package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Login;
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
            Login login = usuarioRepository.findByEmail(username);
            if (login == null) {
                System.out.println("login not found with the provided login");
                return null;
            }
            System.out.println("login from login " + login.toString());
            return new org.springframework.security.core.userdetails.User(login.getEmail(), login.getPassword(), new ArrayList<>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("Login not found");
        }
    }
}
