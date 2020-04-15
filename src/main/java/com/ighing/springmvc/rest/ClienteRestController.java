package com.ighing.springmvc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ighing.springmvc.entity.Cliente;
import com.ighing.springmvc.service.ClienteService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> clientes = clienteService.getAll();
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> getCliente(@PathVariable int clienteId) {
		Cliente clienteResponse = clienteService.get(clienteId);
		return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
	}

	@PostMapping
	ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		Cliente clienteResponse = clienteService.create(cliente);
		return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
	}

	@PutMapping("/{clienteId}")
	ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable int clienteId) {
		cliente.setId(clienteId);
		Cliente clienteResponse = clienteService.update(cliente);
		return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{clienteId}")
	ResponseEntity<Void> deleteCliente(@PathVariable int clienteId) {
		clienteService.delete(clienteId);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}

}