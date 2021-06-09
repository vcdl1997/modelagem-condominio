package entities;

import java.util.ArrayList;
import java.util.List;

public class Condominio {
	private String nome;
	private String endere�o;
	private List<Apartamento> apartamentos;
	

	public Condominio(String nome, String endere�o) {
		this.nome = nome;
		this.endere�o = endere�o;
	}
	
	public Condominio(String nome, String endere�o, List<Apartamento> apartamento) {
		this.nome = nome;
		this.endere�o = endere�o;
		this.apartamentos = apartamento;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndere�o() {
		return endere�o;
	}
	
	public void reportApartamentos() {
		if(this.apartamentos.size() > 0) {
			System.out.println("Relat�rio de Condominos " + this.getNome() + "\n");		
			
			for(Apartamento apartamento : this.apartamentos) {
						
				System.out.println("N�mero do Apartamento: " + apartamento.getNumero());
				System.out.println("Tamanho do Apartamento: " + apartamento.getMetragem() + "m�");
				System.out.println("Situa��o do Apartamento: " + apartamento.getStatus());
				System.out.println("Propriet�rio: " + apartamento.getProprietario().getName());
				
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
