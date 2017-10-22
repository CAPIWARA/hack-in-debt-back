package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
