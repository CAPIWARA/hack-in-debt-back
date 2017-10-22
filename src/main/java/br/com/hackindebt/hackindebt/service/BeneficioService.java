package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Beneficio;
import br.com.hackindebt.hackindebt.model.Estudante;
import br.com.hackindebt.hackindebt.model.TipoBeneficio;
import br.com.hackindebt.hackindebt.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficioService {

    @Autowired
    private BeneficioRepository beneficioRepository;

    @Autowired
    private EstudanteService estudanteService;

    public List<Beneficio> findByAtivoTrue() {
        return beneficioRepository.findByAtivoTrue();
    }

    public boolean resgatarBeneficio(Long idbeneficio, String email) throws Exception {
        Beneficio beneficio = beneficioRepository.findOne(idbeneficio);
        Estudante estudante = estudanteService.fazerCalculos(email);
        if (beneficio.getTipoBeneficio() == TipoBeneficio.GEMAS) {
            if (beneficio.getPontosNecessarios() <= estudante.getGema()) return true;
            return false;
        }
        if (beneficio.getTipoBeneficio() == TipoBeneficio.OURO) {
            if (beneficio.getPontosNecessarios() <= estudante.getOuro()) return true;
            return false;
        }
        return false;
    }
}
