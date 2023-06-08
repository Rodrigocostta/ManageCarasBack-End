package com.manageCars.manageCars.DTOs;

public class OrdemServicoDTO {
	private Long id;
	private String nome;
	private String modelo;
	private String placa;
	private String servico;
	private Double total;

	public OrdemServicoDTO( String nome,String modelo, String placa, String servico, Double total) {
	
		this.nome = nome;
		this.modelo = modelo;

		this.placa = placa;
		this.servico = servico;
		this.total = total;
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}