package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Login, Integer> {
    Login findByEmail(String email);
}
