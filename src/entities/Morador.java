package entities;

import java.util.Date;

import entities.enums.EstadoCivilPessoa;

public class Morador extends Pessoa{
	
	public Morador(
		String name, 
		Long cpf, 
		Date nascimento, 
		String email, 
		Long celular, 
		Long telefone,
		EstadoCivilPessoa estadoCivil
	) 
	{
		super(name, cpf, nascimento, email, celular, telefone, estadoCivil);
	}
		
		
	public Morador(
		String name, 
		Long cpf, 
		String email
	) 
	{
		super(name, cpf, email);
	}
	
	
	public Morador(
		String name, 
		Long cpf
	) 
	{
		super(name, cpf);
	}
}
