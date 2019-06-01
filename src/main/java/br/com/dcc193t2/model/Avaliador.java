package br.com.dcc193t2.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

/**
 * Avaliador
 */
@Entity
public class Avaliador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String email;
    private String codigoAcesso;

    @OneToMany
    private List<AreaConhecimento> areaConhecimento;

    public Avaliador() {
    }

    public Avaliador(Long id, String nome, String email, String codigoAcesso, List<AreaConhecimento> areaConhecimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.codigoAcesso = codigoAcesso;
        this.areaConhecimento = areaConhecimento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoAcesso() {
        return this.codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
    }

    public List<AreaConhecimento> getAreaConhecimento() {
        return this.areaConhecimento;
    }

    public void setAreaConhecimento(List<AreaConhecimento> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public Avaliador id(Long id) {
        this.id = id;
        return this;
    }

    public Avaliador nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Avaliador email(String email) {
        this.email = email;
        return this;
    }

    public Avaliador codigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
        return this;
    }

    public Avaliador areaConhecimento(List<AreaConhecimento> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
        return this;
    }

    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", codigoAcesso='" + getCodigoAcesso() + "'" +
            ", areaConhecimento='" + getAreaConhecimento() + "'" +
            "}";
    }


}