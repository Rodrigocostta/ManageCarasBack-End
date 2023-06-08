package com.manageCars.manageCars.DTOs;

public class ClienteVeiculoDTO {
    private ClienteDTO cliente;
    private VeiculoDTO veiculo;

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public VeiculoDTO getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoDTO veiculo) {
        this.veiculo = veiculo;
    }
}
