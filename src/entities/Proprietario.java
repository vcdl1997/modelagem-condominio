package entities;

import java.util.Date;

import entities.enums.EstadoCivilPessoa;

public class Proprietario extends Pessoa{
	
	private Boolean ehMorador;

	public Proprietario(
		String name, 
		Long cpf, 
		Date nascimento, 
		String email, 
		Long celular, 
		Long telefone,
		EstadoCivilPessoa estadoCivil,
		Boolean ehMorador
	) 
	{
		super(name, cpf, nascimento, email, celular, telefone, estadoCivil);
		this.ehMorador = ehMorador;
	}

	
	public Proprietario(
		String name, 
		Long cpf, 
		String email,
		Boolean ehMorador
	) {
		super(name, cpf, email);
		this.ehMorador = ehMorador;
	}
	
	
	public Boolean getEhMorador() {
		return this.ehMorador;
	}
	
	public void setEhMorador(Boolean ehMorador) {
		this.ehMorador = ehMorador;
	}
}
