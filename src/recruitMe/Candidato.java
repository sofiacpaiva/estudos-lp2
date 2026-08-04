package recruitMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Candidato {
	private String nome;
	private String email; //identificador
	private List<Experiencia> experiencias;
	
	public Candidato(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.experiencias = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(email, other.email);
	}
	
	@Override
	public String toString() {
		return "Candidato [nome=" + nome + ", email=" + email + "]";
	}
	
	public void adicionaExperiencia(Experiencia e) {
		experiencias.add(e);
	}
	
	public String[] listaExperiencias() {
		String [] listagem = new String[experiencias.size()];
		for (int i = 0; i < listagem.length; i++) {
			listagem[i] = experiencias.get(i).toString();
		}
		return listagem;
	}
	
	
	public double calculaPontuacaoTotal() {
		double pontos = 0;
		for (Experiencia e : experiencias) {
			pontos += e.calculaPontuacao();
		}
		return pontos;
	}
}
