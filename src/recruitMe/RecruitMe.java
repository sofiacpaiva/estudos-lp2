package recruitMe;

import java.util.HashMap;
import java.util.Map;

public class RecruitMe {
	private Map<String, Candidato> candidatos;
	private Map<String, Oportunidade> oportunidades;

	public RecruitMe() {
		this.candidatos = new HashMap<>();
		this.oportunidades = new HashMap<>();
	}
	
	public boolean cadastrarCandidato(String nome, String email) {
		if (candidatos.containsKey(email)) {
			return false;
		}
		Candidato c = new Candidato(nome, email);
		candidatos.put(email, c);
		return true;
	}
	
	public String[] listarCandidatos() {
		String[] lista = new String[candidatos.size()];
		int i = 0;
		for (Candidato c : this.candidatos.values()) {
			lista[i] = c.getEmail();
		}
		return lista;
	}
	
	public boolean cadastrarOportunidade(String nomeProjeto, int tam, double pontos) {
		if (oportunidades.containsKey(nomeProjeto)) {
			return false;
		}
		Oportunidade o = new Oportunidade(nomeProjeto, tam, pontos);
		oportunidades.put(nomeProjeto, o);
		return true; 
	}
	
	public String[] listarOportunidades() {
		String[] lista = new String[oportunidades.size()];
		int i = 0;
		for (Oportunidade o : this.oportunidades.values()) {
			lista[i] = o.getNomeProjeto();
		}
		return lista;
	}
	
	public boolean adicionaCandidatoOportunidade(String email, String nomeProjeto) {
		Oportunidade o = localizaOportunidade(nomeProjeto);
		if (o.getCandidatos().containsKey(email)) {
			return false;
		}
		Candidato c = localizaCandidato(email);
		o.addCandidato(email, c);
		return true; 
	}
	
	public String[] listarSelecionadosPorOportunidade(String nomeProjeto) {
		Oportunidade o = localizaOportunidade(nomeProjeto);
		return o.listaCandidatosSelecionados();
	}
	
	public void cadastrarExperienciaDesenvolvimento(String email, String descricao, String URL, int nFiles, int valor_base) {
		Candidato c = localizaCandidato(email);
		Experiencia e = new ExperienciaDesenvolvimento(valor_base, descricao, URL, nFiles);
		c.adicionaExperiencia(e);
	}
	
	public void cadastrarExperienciaRepresentacao(String email, String cargo, int semestres, boolean eleito, boolean institucional, int valor_base) {
		Candidato c = localizaCandidato(email);
		Experiencia e = new ExperienciaRepresentacao(valor_base, cargo, semestres, eleito, institucional);
		c.adicionaExperiencia(e);
	}
	
	public void cadastrarExperienciaRecomendacao(String email, String prof, String carta, int aval, int valor_base) {
		Candidato c = localizaCandidato(email);
		Experiencia e = new ExperienciaRecomendacao(valor_base, prof, carta, aval);
		c.adicionaExperiencia(e);
	}
	
	public String[] listarExperienciasCandidato(String email) {
		Candidato c = localizaCandidato(email);
		return c.listaExperiencias();
	}
	
	public double exibirPontosExperienciasCandidato(String email) {
		Candidato c = localizaCandidato(email);
		return c.calculaPontuacaoTotal();
	}
	
	
	private Candidato localizaCandidato(String email) {
		if (!candidatos.containsKey(email)) {
			throw new IllegalArgumentException("Candidato inexistente");
		}
		return candidatos.get(email);
	}
	
	private Oportunidade localizaOportunidade(String nomeProjeto) {
		if (!oportunidades.containsKey(nomeProjeto)) {
			throw new IllegalArgumentException("Oportunidade inexistente");
		}
		return oportunidades.get(nomeProjeto);
	}
	
}
