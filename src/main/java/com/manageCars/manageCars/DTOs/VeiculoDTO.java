package com.manageCars.manageCars.DTOs;
public class VeiculoDTO {

    private String marca;
    private String modelo;
    private String placa;
    
    //construtores
	public VeiculoDTO(String marca, String modelo, String placa) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
    
    
    
    
    
}
