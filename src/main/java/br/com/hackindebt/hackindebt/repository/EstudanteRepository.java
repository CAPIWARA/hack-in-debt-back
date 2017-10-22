package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Estudante;
import br.com.hackindebt.hackindebt.model.Login;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    Estudante findByLogin(Login login);
}
