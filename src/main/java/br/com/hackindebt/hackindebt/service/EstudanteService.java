package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Estudante;
import br.com.hackindebt.hackindebt.model.Perfil;
import br.com.hackindebt.hackindebt.repository.EstudanteRepository;
import br.com.hackindebt.hackindebt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public void saveEstudante(Estudante estudante) throws Exception {
        Utils.validate(estudante);
        Utils.validate(estudante.getLogin());
        Utils.validate(estudante.getLogin().getEmail());
        Utils.validate(estudante.getLogin().getPassword());
        estudante.getLogin().setId(0L);
        Utils.validate(estudante.getCpf());
        Utils.validate(estudante.getNome());
        Utils.validate(estudante.getCpf());
        estudante.getLogin().setPerfil(Perfil.ESTUDANTE);
        estudanteRepository.save(estudante);
    }
}

