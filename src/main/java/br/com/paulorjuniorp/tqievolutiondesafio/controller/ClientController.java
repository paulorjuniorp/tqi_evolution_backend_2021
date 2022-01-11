package br.com.paulorjuniorp.tqievolutiondesafio.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Client;
import br.com.paulorjuniorp.tqievolutiondesafio.dtos.ClientDTO;
import br.com.paulorjuniorp.tqievolutiondesafio.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findClientById(@PathVariable Long id) {

		Client findClient = clientService.findById(id);

		return ResponseEntity.ok().body(findClient);
	}

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {

		List<Client> listClient = clientService.findAll();
		List<ClientDTO> listClientDTO = listClient.stream().map(objCli -> new ClientDTO(objCli))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listClientDTO);
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(@Valid @RequestBody Client objClient){
		
		objClient = clientService.createClient(objClient);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objClient.getId()).toUri();
		return ResponseEntity.created(uri).body(objClient);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ClientDTO> updateClient(@Valid @PathVariable Long id, @RequestBody ClientDTO objClientDTO){
		
		Client updateClient = clientService.updateClient(id, objClientDTO);
		return ResponseEntity.ok().body(new ClientDTO(updateClient));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id){
		clientService.deleteClient(id);
		return ResponseEntity.noContent().build();
	}
}
