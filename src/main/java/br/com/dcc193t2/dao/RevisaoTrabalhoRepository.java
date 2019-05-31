package br.com.dcc193t2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dcc193t2.model.RevisaoTrabalho;

/**
 * RevisaoRepository
 */
@Repository
public interface RevisaoTrabalhoRepository extends JpaRepository<RevisaoTrabalho, Long> {

    
}