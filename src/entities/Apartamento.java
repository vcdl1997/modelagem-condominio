package entities;

import java.util.List;
import java.util.stream.Collectors;

import entities.enums.StatusApartamento;

public class Apartamento {
	private Integer numero;
	private Integer metragem;
	private Integer quartos;
	private Integer suites;
	private Integer banheiros;
	private Integer vagas;
	private Boolean mobiliado;
	private Proprietario proprietario;
	private List<Morador> moradores;
	private StatusApartamento status;
	
	
	public Apartamento(
		Integer numero, 
		Integer metragem, 
		Integer quartos, 
		Integer suites, 
		Integer banheiros,
		Integer vagas, 
		Boolean mobiliado, 
		Proprietario proprietario, 
		List<Morador> moradores,
		StatusApartamento status
	) 
	{
		this.numero = numero;
		this.metragem = metragem;
		this.quartos = quartos;
		this.suites = suites;
		this.banheiros = banheiros;
		this.vagas = vagas;
		this.mobiliado = mobiliado;
		this.proprietario = proprietario;
		this.moradores = moradores;
		this.status = status;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Integer getMetragem() {
		return metragem;
	}
	

	public Integer getQuartos() {
		return quartos;
	}

	
	public Integer getSuites() {
		return suites;
	}

	
	public Integer getBanheiros() {
		return banheiros;
	}

	public Integer getVagas() {
		return vagas;
	}

	public Boolean getMobiliado() {
		return mobiliado;
	}


	public void setMobiliado(Boolean mobiliado) {
		this.mobiliado = mobiliado;
	}


	public Proprietario getProprietario() {
		return proprietario;
	}


	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	public List<Morador> getMoradores() {
		if(this.proprietario.getEhMorador()) {
			String name = this.proprietario.getName();
			Long cpf = this.proprietario.getCpf();
			this.moradores.add(0, new Morador(name, cpf));
		}
		
		return this.moradores.stream().distinct().collect(Collectors.toList());
	}

	public void adicionarMorador(Morador morador) {
		this.moradores.add(morador);
	}
	
	public void removerMorador(Morador morador) {
		Morador moradorRemovido = this.moradores.stream().filter(x -> x.getCpf() == morador.getCpf()).findFirst().orElse(null);
		
		if(moradorRemovido != null) {
			this.moradores.remove(moradorRemovido);
		}
	}
	
	
	public StatusApartamento getStatus() {
		return status;
	}


	public void setStatus(StatusApartamento status) {
		this.status = status;
	}
	
	
}
