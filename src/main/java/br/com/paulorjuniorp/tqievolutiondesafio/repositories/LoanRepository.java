package br.com.paulorjuniorp.tqievolutiondesafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

}
