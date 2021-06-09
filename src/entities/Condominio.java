package entities;

import java.util.ArrayList;
import java.util.List;

public class Condominio {
	private String nome;
	private String endereço;
	private List<Apartamento> apartamentos;
	

	public Condominio(String nome, String endereço) {
		this.nome = nome;
		this.endereço = endereço;
	}
	
	public Condominio(String nome, String endereço, List<Apartamento> apartamento) {
		this.nome = nome;
		this.endereço = endereço;
		this.apartamentos = apartamento;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereço() {
		return endereço;
	}
	
	public void reportApartamentos() {
		if(this.apartamentos.size() > 0) {
			System.out.println("Relatório de Condominos " + this.getNome() + "\n");		
			
			for(Apartamento apartamento : this.apartamentos) {
						
				System.out.println("Número do Apartamento: " + apartamento.getNumero());
				System.out.println("Tamanho do Apartamento: " + apartamento.getMetragem() + "m²");
				System.out.println("Situação do Apartamento: " + apartamento.getStatus());
				System.out.println("Proprietário: " + apartamento.getProprietario().getName());
				
				if(apartamento.getMoradores().size() > 0) {
					System.out.println("Moradores residentes: ");
					
					List<Morador> moradores = new ArrayList<>();
					
					for(Morador morador : apartamento.getMoradores()) {
						Morador match = moradores.stream().filter(x -> x.getCpf().equals(morador.getCpf())).findFirst().orElse(null);
						
						if(match == null) {
							moradores.add(morador);
							System.out.println(morador.getName());
						}
					}
					System.out.println("");
				}
			}
		}
	}
	
	public void adicionarApartamento(Apartamento apartamento) {
		this.apartamentos.add(apartamento);
	}
}
