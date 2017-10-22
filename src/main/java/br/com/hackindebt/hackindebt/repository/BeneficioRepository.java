package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
}
