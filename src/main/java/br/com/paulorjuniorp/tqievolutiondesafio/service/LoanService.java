package br.com.paulorjuniorp.tqievolutiondesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Client;
import br.com.paulorjuniorp.tqievolutiondesafio.domain.Loan;
import br.com.paulorjuniorp.tqievolutiondesafio.repositories.LoanRepository;
import br.com.paulorjuniorp.tqievolutiondesafio.service.exceptions.ObjectNotFoundException;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ClientService clientService;
	
	public Loan findLoanById(Long idLoan) {
		
		Optional<Loan> objLoan = loanRepository.findById(idLoan);
		
		return objLoan.orElseThrow(() -> new ObjectNotFoundException("Empréstimo não encontrado! Id: " + idLoan + ", Nome: " + Loan.class.getName()));
	}

	public List<Loan> findAllLoans(Long idCli) {
		clientService.findById(idCli);
		return loanRepository.findIdAmountNumberInstallmentsLoanByClientId(idCli);
	}

	public Loan createLoan(Long idCli, Loan loan) {
		loan.setId(null);
		Client cli = clientService.findById(idCli);
		loan.setClient(cli);
		return loanRepository.save(loan);
	}

	public void delete(Long id) {
		Loan objLoan = findLoanById(id);
		loanRepository.delete(objLoan);
	}
}
