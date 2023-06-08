package com.manageCars.manageCars.DTOs;

public class ClienteDTO {

	private String nome;
	private Integer contato;

	// construtuores
	public ClienteDTO(String nome, Integer contato) {
		super();
		this.nome = nome;
		this.contato = contato;
	}

	// getters and setteres

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getContato() {
		return contato;
	}

	public void setContato(Integer contato) {
		this.contato = contato;
	}

}
