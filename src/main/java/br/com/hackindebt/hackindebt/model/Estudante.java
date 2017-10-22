package br.com.hackindebt.hackindebt.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
    private Long media;
    private String cpf;
    private String pesquisaCientifica;
    @JoinColumn
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Login login;
    private Long nivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Long getMedia() {
        return media;
    }

    public void setMedia(Long media) {
        this.media = media;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPesquisaCientifica() {
        return pesquisaCientifica;
    }

    public void setPesquisaCientifica(String pesquisaCientifica) {
        this.pesquisaCientifica = pesquisaCientifica;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }
}
