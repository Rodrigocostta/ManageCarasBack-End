package com.manageCars.manageCars.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manageCars.manageCars.entities.Lancamento;
import com.manageCars.manageCars.servicies.LancamentoService;

@RestController
@RequestMapping(value = "/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoService service;

	
	 // LISTA LANCAMEANTO
	@GetMapping
	ResponseEntity<List<Lancamento>> findAll() {
		List<Lancamento> list = service.findAll();
		return new ResponseEntity<List<Lancamento>>(list,HttpStatus.OK);
	}

	
	    //LISTAR POR ID
	@GetMapping( value ="{id}")
	ResponseEntity<Lancamento> findById(@PathVariable("id") Long id) {
		Lancamento obj = service.findById(id);
		return new ResponseEntity<Lancamento>(obj,HttpStatus.OK);

	}

	// INSERINDO UM NOVO USUARIO
	@PostMapping
	public ResponseEntity<Lancamento> insert(@RequestBody Lancamento obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("${id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	// DELETE POR ID

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Lancamento> update(@PathVariable Long id, @RequestBody Lancamento obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
