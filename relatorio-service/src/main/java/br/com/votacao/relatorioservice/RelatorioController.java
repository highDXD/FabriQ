/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.votacao.relatorioservice;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author FBQ-DEV2
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/relatorio")
public class RelatorioController {

    @GetMapping("/lista")
    @ResponseBody
    public Candidato[] geraRelatorio() {
        RestTemplate restTemplate = new RestTemplate();
        Candidato[] candidatos = restTemplate.getForObject("http://localhost:8000/candidatos/lista", Candidato[].class);
        return candidatos;
    }
}
