/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.service.votoservice;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FBQ-DEV2
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @GetMapping("/lista")
    @ResponseBody
    public List<Candidato> getCandidatos() {
        return candidatoRepository.findAll();
    }

    @PostMapping("/vota")
    @ResponseBody
    public Resposta vota(@RequestBody Candidato candidato) {
        Resposta resposta = new Resposta();
        System.out.println("Entrou no insere " + candidato.getNome());

        Candidato atualizado = candidato;

        int votos = atualizado.getVotos() + 1;

        atualizado.setVotos(votos);

        try {
            candidatoRepository.save(atualizado);
            resposta.setStrResposta("Voto computado!");
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            resposta.setStrResposta("Um erro ocorreu!");

            return resposta;
        }
    }

    @PostMapping("/verifica/{id}")
    @ResponseBody
    public Candidato getCandidatoId(@PathVariable Long id) {
        Optional<Candidato> c = candidatoRepository.findById(id);
        
        Candidato cand = c.get();
        
        return cand;
    }
}
