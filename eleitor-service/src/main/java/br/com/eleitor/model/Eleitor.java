package br.com.eleitor.model;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Table
@Entity
public class Eleitor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private String senha;

	public Eleitor(String name, String senha) {
		super();
		this.name = name;
		this.senha = senha;
	}

	public Eleitor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
