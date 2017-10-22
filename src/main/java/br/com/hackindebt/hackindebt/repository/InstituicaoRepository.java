package br.com.hackindebt.hackindebt.repository;

import br.com.hackindebt.hackindebt.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
}
