package br.com.eleitor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.eleitor.model.Eleitor;
import br.com.eleitor.repository.EleitorRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService  {
	private final EleitorRepository eleitorRepository;

	@Autowired
	public CustomUserDetailsService(EleitorRepository eleitorRepository) {
		super();
		this.eleitorRepository = eleitorRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Eleitor eleitor = Optional.ofNullable(eleitorRepository.findByName(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		List<GrantedAuthority> authorityListEleitor = AuthorityUtils.createAuthorityList("ROLE_ELEITOR");
		return new org.springframework.security.core.userdetails.User
				(eleitor.getName(), eleitor.getSenha(), authorityListEleitor);
	}

}
