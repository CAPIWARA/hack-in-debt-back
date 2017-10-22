package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
