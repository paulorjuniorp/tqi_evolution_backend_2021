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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Loan;
import br.com.paulorjuniorp.tqievolutiondesafio.dtos.LoanDTO;
import br.com.paulorjuniorp.tqievolutiondesafio.service.LoanService;

@RestController
@RequestMapping(value="/clients/{idCli}/loans")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Loan> findLoanById(@PathVariable Long id){
		
		Loan findLoanById = loanService.findLoanById(id);
		
		return ResponseEntity.ok().body(findLoanById);
	}
	
	@GetMapping
	public ResponseEntity<List<LoanDTO>> findAllLoans(@RequestParam(value="listloan", defaultValue = "1") Long idCli){
		List<Loan> listAllLoans = loanService.findAllLoans(idCli);
		List<LoanDTO> listLoanDTO = listAllLoans.stream().map(obj -> new LoanDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listLoanDTO);
	}
	
	@PostMapping
	public ResponseEntity<Loan> createLoan(@RequestParam(value="create") Long idCli,@Valid @RequestBody Loan loan){
		
		Loan newLoan = loanService.createLoan(idCli,loan);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newLoan.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newLoan);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteLoan(@PathVariable Long id){
		
		loanService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
