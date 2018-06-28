package br.com.eleitor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eleitor.model.Eleitor;

public interface EleitorRepository extends PagingAndSortingRepository<Eleitor, Long> {

	Eleitor findByName(String name);
}
