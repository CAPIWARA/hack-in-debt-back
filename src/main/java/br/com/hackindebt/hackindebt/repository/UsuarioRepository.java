package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Login, Integer> {
    List<Login> findByEmail(String email);
}
