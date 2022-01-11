package br.com.paulorjuniorp.tqievolutiondesafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	List<Loan> findIdAmountNumberInstallmentsLoanByClientId(@Param(value="idCli") Long idCli);

}
