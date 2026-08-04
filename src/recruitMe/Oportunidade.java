package recruitMe;

import java.util.HashMap;
import java.util.Map;

public class Oportunidade {
	private String nomeProjeto; //identificador
	private int qtdeMaxPessoas;
	private double minPontos;
	private String status;
	private Map<String, Candidato> candidatos;
	
	public Oportunidade(String nomeProjeto, int qtdePessoas, double minPontos) {
		this.nomeProjeto = nomeProjeto;
		this.qtdeMaxPessoas = qtdePessoas;
		this.minPontos = minPontos;
		this.status = "aberta";
		this.candidatos = new HashMap<>();
	}
	
	
	public void mudaStatus() {
		if (candidatos.size() == qtdeMaxPessoas) {
			this.status = "fechada";
		}
	}

	public int getQtdeMaxPessoas() {
		return qtdeMaxPessoas;
	}


	public double getMinPontos() {
		return minPontos;
	}


	public String getNomeProjeto() {
		return this.nomeProjeto;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void addCandidato(String email, Candidato c) {
		this.candidatos.put(email, c);
	}
	
	public String mensagemSelecao() {
		if (this.status.equals("aberta")) {
			return "Ainda estamos contratando!";
		}
		return "Vagas fechadas!";
	}
	
	public String[] listaCandidatosSelecionados() {
		String[] listagem = new String[candidatos.size()];
		int i = 0;
		for (Candidato c : candidatos.values()) {
			listagem[i] = c.getEmail();
		}
		return listagem;
	}


	public Map<String, Candidato> getCandidatos() {
		return candidatos;
	}
}
