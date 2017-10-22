package br.com.hackindebt.hackindebt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beneficio {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Long pontosNecessarios;
    private String descricao;
    private String foto;


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

    public Long getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(Long pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
