package entities;

import java.util.Date;

import entities.enums.EstadoCivilPessoa;

public abstract class Pessoa {
	private String name;
	private Long cpf;
	private Date nascimento;
	private String email;
	private Long celular;
	private Long telefone;
	private EstadoCivilPessoa estadoCivil;
	
	
	public Pessoa(
		String name, 
		Long cpf, 
		Date nascimento, 
		String email, 
		Long celular, 
		Long telefone,
		EstadoCivilPessoa estadoCivil
	) 
	{
		this.name = name;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.email = email;
		this.celular = celular;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
	}
	
	
	public Pessoa(
		String name, 
		Long cpf, 
		String email
	) 
	{
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}
	
	public Pessoa(
		String name, 
		Long cpf
	) 
	{
		this.name = name;
		this.cpf = cpf;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getCpf() {
		return cpf;
	}
	

	public Date getNascimento() {
		return nascimento;
	}


	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


	public String getEmail() {
		return email;
	}


	public Long getCelular() {
		return celular;
	}


	public void setCelular(Long celular) {
		this.celular = celular;
	}


	public Long getTelefone() {
		return telefone;
	}


	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public EstadoCivilPessoa getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilPessoa estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}
