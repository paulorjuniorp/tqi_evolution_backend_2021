package br.com.paulorjuniorp.tqievolutiondesafio.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.paulorjuniorp.tqievolutiondesafio.domain.Loan;

public class LoanDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty
	private BigDecimal loanAmount;

	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate firstInstallmentDate;

	@NotEmpty
	@Length(min = 1, max = 60)
	private Integer numberInstallments;

	public LoanDTO() {
		super();
	}

	public LoanDTO(Loan objLoan) {
		super();
		this.id = objLoan.getId();
		this.loanAmount = objLoan.getLoanAmount();
		this.firstInstallmentDate = objLoan.getFirstInstallmentDate();
		this.numberInstallments = objLoan.getNumberInstallments();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public LocalDate getFirstInstallmentDate() {
		return firstInstallmentDate;
	}

	public void setFirstInstallmentDate(LocalDate firstInstallmentDate) {
		this.firstInstallmentDate = firstInstallmentDate;
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

}
