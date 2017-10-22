package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Instituicao;
import br.com.hackindebt.hackindebt.model.Perfil;
import br.com.hackindebt.hackindebt.repository.InstituicaoRepository;
import br.com.hackindebt.hackindebt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoService {
    @Autowired
    private InstituicaoRepository instituicaoRepository;

    public void saveInstituicao(Instituicao instituicao) throws Exception {
        Utils.validate(instituicao);
        Utils.validate(instituicao.getLogin());
        Utils.validate(instituicao.getLogin().getEmail());
        Utils.validate(instituicao.getLogin().getPassword());
        instituicao.getLogin().setId(0L);
        Utils.validate(instituicao.getCnpj());
        Utils.validate(instituicao.getNome());
        Utils.validate(instituicao.getTelefone());
        Utils.validate(instituicao.getEndereco());
        instituicao.getLogin().setPerfil(Perfil.INSTITUICAO);
        instituicao.setId(0L);

        instituicaoRepository.save(instituicao);
    }
}
