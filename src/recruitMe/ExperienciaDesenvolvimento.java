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
		return (super.valor_base*nFiles)/10;
	}

	@Override
	public String toString() {
		return "ExperienciaDesenvolvimento [descricao=" + descricao + ", URL=" + URL + ", nFiles=" + nFiles + ", pontuacao=" + calculaPontuacao() + "]";
	}



}
