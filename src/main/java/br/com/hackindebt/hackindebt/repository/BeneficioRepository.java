package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
    List<Beneficio> findByAtivoTrue();
}
