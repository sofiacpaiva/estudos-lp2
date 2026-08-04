package recruitMe;

public class ExperienciaRepresentacao extends Experiencia {
	private String cargo;
	private int semestres;
	private boolean eleito;
	private boolean institucional;
	
	
	public ExperienciaRepresentacao(int valor_base, String cargo, int semestres, boolean eleito,
			boolean institucional) {
		super(valor_base);
		this.cargo = cargo;
		this.semestres = semestres;
		this.eleito = eleito;
		this.institucional = institucional;
	}

	@Override
	public double calculaPontuacao() {
		return semestres*calculaBonus();
	}


	
	@Override
	public String exibeDetalhamento(int codigo) {
		return "ExperienciaRepresentacao#" + codigo + "[cargo=" + cargo + ", semestres=" + semestres + ", eleito=" + eleito
				+ ", institucional=" + institucional + ", pontuacao=" + calculaPontuacao() + "]";
	}

	private int calculaBonus() {
		if (eleito == true && institucional == false) {
			return 2;
		} else if (eleito == false && institucional == true) {
			return 2;
		} else if (eleito == true && institucional == true) {
			return 4;
		}
		return 0;
	}

}
