package com.manageCars.manageCars.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.manageCars.manageCars.entities.Usuario;
import com.manageCars.manageCars.reposytories.UsuarioRepository;
import com.manageCars.manageCars.servicies.exeptions.ResourceNotFoundException;

@org.springframework.stereotype.Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	/* listar todos */

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	/* Buscando com parametro */
	public Usuario findById(long id) {

		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	// INSERT
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);

	}



}
