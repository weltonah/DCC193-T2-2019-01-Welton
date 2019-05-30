package br.com.dcc193t2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AreaConhecimento {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;

    @ManyToOne
    @JoinColumn(name="avaliador_id")
    private Avaliador refAvaliador;


    public AreaConhecimento() {
    }

    public AreaConhecimento(Long id, String descricao, Avaliador refAvaliador) {
        this.id = id;
        this.descricao = descricao;
        this.refAvaliador = refAvaliador;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Avaliador getRefAvaliador() {
        return this.refAvaliador;
    }

    public void setRefAvaliador(Avaliador refAvaliador) {
        this.refAvaliador = refAvaliador;
    }

    public AreaConhecimento id(Long id) {
        this.id = id;
        return this;
    }

    public AreaConhecimento descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public AreaConhecimento refAvaliador(Avaliador refAvaliador) {
        this.refAvaliador = refAvaliador;
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", refAvaliador='" + getRefAvaliador() + "'" +
            "}";
    }

}
