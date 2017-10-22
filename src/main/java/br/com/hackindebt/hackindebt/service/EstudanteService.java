package br.com.hackindebt.hackindebt.service;

import br.com.hackindebt.hackindebt.model.Estudante;
import br.com.hackindebt.hackindebt.model.Login;
import br.com.hackindebt.hackindebt.model.Perfil;
import br.com.hackindebt.hackindebt.model.StatusPagamento;
import br.com.hackindebt.hackindebt.repository.EstudanteRepository;
import br.com.hackindebt.hackindebt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private UsuarioService loginService;

    public void saveEstudante(Estudante estudante) throws Exception {
        Utils.validate(estudante);
        Utils.validate(estudante.getLogin());
        Utils.validate(estudante.getLogin().getEmail());
        Utils.validate(estudante.getLogin().getPassword());
        estudante.getLogin().setAtivo(true);
        estudante.getLogin().setId(0L);
        Utils.validate(estudante.getCpf());
        Utils.validate(estudante.getNome());
        Utils.validate(estudante.getCpf());
        estudante.getLogin().setPerfil(Perfil.ESTUDANTE);
        estudante.setId(0L);
        estudanteRepository.save(estudante);
    }

    /**
     * Metodo para efetuar o calculo do ouro do estudante
     *
     * @param media
     * @param iniciacaoCientifica
     * @return
     */
    public Long calcularOuro(Long media, Boolean iniciacaoCientifica) {
        if (media == null || media < 0 || media > 10) media = 0L;
        return (iniciacaoCientifica == true ? 3000 : 0) + (media > 0 ? media * 100 : 0);
    }

    /**
     * Metodo para efetuar o calculo das gemas do estudante
     *
     * @param statusPagamento
     * @param saldo
     * @return
     */
    public Long calcularGema(StatusPagamento statusPagamento, Long saldo) {
        System.out.println("Saldo: " + saldo);
        System.out.println("statusPagamento: " + statusPagamento);
        if (statusPagamento == StatusPagamento.PAGAMENTO_ADIANTADO) return saldo + 500L;
        if (statusPagamento == StatusPagamento.PAGAMENTO_OK) return saldo + 200L;
        if (statusPagamento == StatusPagamento.PAGAMENTO_ATRASADO) return saldo - 300L;
        System.out.println("VAAAAAAALOR: " + saldo);
        return saldo;
    }

    public Estudante fazerCalculos(String email) throws Exception {
        Estudante estudante = buscarEstudante(email);
        
        if (estudante == null) throw new Exception("Estudante não encontrado");
        estudante.setOuro(calcularOuro(estudante.getMedia(), estudante.isPesquisaCientifica()));
        Long saldo = calcularGema(estudante.getStatusPagamento(),
                estudante.getGema() == null ? 0 : estudante.getGema());
        System.out.println("SALDO ATUAL: " + saldo);
        estudante.setGema(saldo);
        return estudante;
    }

    public Estudante buscarEstudante(String email) {
        Login login = loginService.findByEmail(email);
        Estudante estudante = estudanteRepository.findByLogin(login);
        return estudante;
    }

}

