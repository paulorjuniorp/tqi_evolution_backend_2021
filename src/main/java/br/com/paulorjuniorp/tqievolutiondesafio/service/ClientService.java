package br.com.paulorjuniorp.tqievolutiondesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Client;
import br.com.paulorjuniorp.tqievolutiondesafio.dtos.ClientDTO;
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
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client createClient(Client objClient) {
		objClient.setId(null);
		return clientRepository.save(objClient);
	}

	public Client updateClient(Long id, ClientDTO objClientDTO) {
		
		Client objClient = findById(id);
		objClient.setName(objClientDTO.getName());
		objClient.setEmail(objClientDTO.getEmail());
		objClient.setCpf(objClientDTO.getCpf());
		objClient.setRg(objClientDTO.getRg());
		objClient.setAddress(objClientDTO.getAddress());
		objClient.setIncome(objClientDTO.getIncome());
		objClient.setPassword(objClientDTO.getPassword());
		
		return clientRepository.save(objClient);
	}

	public void deleteClient(Long idClient) {
		findById(idClient);
		try {
			clientRepository.deleteById(idClient);	
		} catch (DataIntegrityViolationException e) {
			throw new br.com.paulorjuniorp.tqievolutiondesafio.service.exceptions.DataIntegrityViolationException("Cliente não pode ser deletado, pois possui emprestimo cadastrado");
		}
		
	}
}
