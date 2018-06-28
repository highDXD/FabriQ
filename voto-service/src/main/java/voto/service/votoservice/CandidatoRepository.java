/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.service.votoservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author FBQ-DEV2
 */
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

    Candidato findByNome(String nome);
    
}
