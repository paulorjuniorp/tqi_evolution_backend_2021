package br.com.paulorjuniorp.tqievolutiondesafio.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.paulorjuniorp.tqievolutiondesafio.domain.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	@NotEmpty
	@Length(min = 3, max = 100)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String cpf;
	
	@NotEmpty
	private String rg;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private BigDecimal income;
	
	@NotEmpty
	@Length(min = 8, max = 16)
	private String password;

	public ClientDTO() {
		super();
	}

	public ClientDTO(Client clientObj) {
		super();
		this.id = clientObj.getId();
		this.name = clientObj.getName();
		this.email = clientObj.getEmail();
		this.cpf = clientObj.getCpf();
		this.rg = clientObj.getRg();
		this.address = clientObj.getAddress();
		this.income = clientObj.getIncome();
		this.password = clientObj.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
