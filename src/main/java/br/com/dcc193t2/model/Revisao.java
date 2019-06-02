package br.com.dcc193t2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Revisao
 */
@Entity
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int nota;
    private String descricao;
    private int status;

    @ManyToOne
    private Avaliador refavaliador;

    @ManyToOne
    private Trabalho reftrabalho;


    public Revisao() {

    }

    public Revisao(Avaliador avaliador, Trabalho trabalho, int nota, String descricao, int status) {
        this.refavaliador = avaliador;
        this.reftrabalho = trabalho;
        this.nota = nota;
        this.descricao = descricao;
        this.status = status;

    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Avaliador getRefavaliador() {
        return refavaliador;
    }

    public void setRefavaliador(Avaliador refavaliador) {
        this.refavaliador = refavaliador;
    }

    public Trabalho getReftrabalho() {
        return reftrabalho;
    }

    public void setReftrabalho(Trabalho reftrabalho) {
        this.reftrabalho = reftrabalho;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", refavaliador='" + getRefavaliador().toString() + "'" +
            ", reftrabalho='" + getReftrabalho().toString() + "'" +
            ", nota='" + getNota() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}