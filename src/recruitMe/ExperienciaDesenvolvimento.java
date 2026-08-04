package recruitMe;

public class ExperienciaDesenvolvimento extends Experiencia {
	private String descricao;
	private String URL;
	private int nFiles;
	
	
	public ExperienciaDesenvolvimento(int valor_base, String descricao, String URL, int nFiles) {
		super(valor_base);
		this.descricao = descricao;
		this.URL = URL;
		this.nFiles = nFiles;
	}

	@Override
	public double calculaPontuacao() {
		return (valor_base*nFiles)/10.0;
	}

	@Override
	public String exibeDetalhamento(int codigo) {
		return "ExperienciaDesenvolvimento#" + codigo + "[descricao=" + descricao + ", URL=" + URL + ", nFiles=" + nFiles + ", pontuacao=" + calculaPontuacao() + "]";
	}



}
