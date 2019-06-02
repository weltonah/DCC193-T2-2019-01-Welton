package br.com.dcc193t2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t2.model.AreaConhecimento;
import br.com.dcc193t2.model.Avaliador;

/**
 * AvaliadorRepository
 */
@Repository
public interface AvaliadorRepository extends JpaRepository<Avaliador, Long> {

	Avaliador findFirstByEmailAndCodigoAcesso(String email, String codigoAcesso);

	List<Avaliador> findByAreaConhecimento(AreaConhecimento areaConhecimento);

}