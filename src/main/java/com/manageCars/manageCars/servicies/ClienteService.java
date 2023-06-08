package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageCars.manageCars.DTOs.ClienteDTO;
import com.manageCars.manageCars.DTOs.ClienteVeiculoDTO;
import com.manageCars.manageCars.DTOs.VeiculoDTO;
import com.manageCars.manageCars.entities.Cliente;
import com.manageCars.manageCars.entities.Veiculo;
import com.manageCars.manageCars.reposytories.ClienteRepository;
import com.manageCars.manageCars.reposytories.VeiculoRepository;
import com.manageCars.manageCars.servicies.exeptions.DataIntegrityViolationException;
import com.manageCars.manageCars.servicies.exeptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	/* listar todos */

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	/* Buscando com parametro */
	public Cliente findById(long id) {

		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
				
	}

	// INSERT
	public Cliente insert(Cliente obj) {
		return clienteRepository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		if(id != null) {
		clienteRepository.deleteById(id);

	}else {
		throw new DataIntegrityViolationException(id);
	}
	}

	public Cliente update(Long id, Cliente obj) {
		Cliente entity = clienteRepository.getReferenceById(id);
		updateDate(entity, obj);
		return clienteRepository.save(entity);
	}

	private void updateDate(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setContato(obj.getContato());

	}

	@Transactional
	public void salvarClienteComVeiculo(ClienteVeiculoDTO clienteVeiculoDTO) {
		ClienteDTO clienteDTO = clienteVeiculoDTO.getCliente();
		VeiculoDTO veiculoDTO = clienteVeiculoDTO.getVeiculo();

		Cliente cliente = new Cliente();
		cliente.setNome(clienteDTO.getNome());
		cliente.setContato(clienteDTO.getContato());

		clienteRepository.save(cliente);

		Veiculo veiculo = new Veiculo();
		veiculo.setMarca(veiculoDTO.getMarca());
		veiculo.setModelo(veiculoDTO.getModelo());
		veiculo.setPlaca(veiculoDTO.getPlaca());


		veiculo.setCliente(cliente);
		veiculoRepository.save(veiculo);
	}

}
