package br.com.eleitor.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eleitor.error.ResourceNotFoundException;
import br.com.eleitor.model.Eleitor;
import br.com.eleitor.repository.EleitorRepository;


@Component
@RestController
@RequestMapping("eleitores")
public class EleitorController {

	@Autowired
	private EleitorRepository eleitorRepository;

	@GetMapping
	public ResponseEntity<?> listAll() {
		return new ResponseEntity<>(eleitorRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<?> getEleitorById(@PathVariable("id") Long id) {
		verifyIfEleitorExists(id);

		Optional<Eleitor> eleitor = eleitorRepository.findById(id);
		return new ResponseEntity<>(eleitor, HttpStatus.OK);
	}

	@GetMapping(path = "findByName/{name}")
	public ResponseEntity<?> getEleitorByName(@PathVariable("name") String name) {
		return new ResponseEntity<>(eleitorRepository.findByName(name), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Eleitor eleitor) {
		return new ResponseEntity<>(eleitorRepository.save(eleitor), HttpStatus.OK);
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfEleitorExists(id);

		eleitorRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Eleitor eleitor) {
		verifyIfEleitorExists(eleitor.getId());

		eleitorRepository.save(eleitor);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private void verifyIfEleitorExists(Long id) {
		if (eleitorRepository.findById(id) == null)
			throw new ResourceNotFoundException("eleitor not found for ID: " + id);
	}
}
