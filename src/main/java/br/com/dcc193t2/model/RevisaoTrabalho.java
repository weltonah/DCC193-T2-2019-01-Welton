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
public class RevisaoTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Avaliador refavaliador;

    @ManyToOne
    private Trabalho reftrabalho;

    private int nota;

    private String descricao;

    private int status;

    public RevisaoTrabalho() {

    }

    public RevisaoTrabalho(Avaliador avaliador, Trabalho trabalho, int nota, String descricao, int status) {
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

}