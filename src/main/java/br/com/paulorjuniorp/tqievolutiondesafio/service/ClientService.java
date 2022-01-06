package br.com.paulorjuniorp.tqievolutiondesafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Client;
import br.com.paulorjuniorp.tqievolutiondesafio.repositories.ClientRepository;
import br.com.paulorjuniorp.tqievolutiondesafio.service.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client findById(Long idClient) {
		
		Optional<Client> objClient = clientRepository.findById(idClient);
		
		return objClient.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! Id: " + idClient + ", Nome: " + Client.class.getName()));
	}
}
