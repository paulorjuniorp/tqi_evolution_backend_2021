package br.com.paulorjuniorp.tqievolutiondesafio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Client;
import br.com.paulorjuniorp.tqievolutiondesafio.service.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	private ClientService clientService;

	@GetMapping(value="/{id}")
	public ResponseEntity<Client> findClientById(@PathVariable Long idClient){
		
		Client findClient = clientService.findById(idClient);
		
		return ResponseEntity.ok().body(findClient);
	}
}
