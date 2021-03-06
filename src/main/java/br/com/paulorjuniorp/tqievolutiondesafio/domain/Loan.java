package br.com.paulorjuniorp.tqievolutiondesafio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private BigDecimal loanAmount;
	
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
	private LocalDate firstInstallmentDate;
	
	@NotEmpty
	@Length(min = 1, max = 60)
	private Integer numberInstallments;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(Long id, BigDecimal loanAmount, LocalDate firstInstallmentDate, Integer numberInstallments,
			Client client) {
		super();
		this.id = id;
		this.loanAmount = loanAmount;
		this.firstInstallmentDate = firstInstallmentDate;
		this.numberInstallments = numberInstallments;
		this.client = client;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(id, other.id);
	}

}
