package recruitMe;

public class ExperienciaRecomendacao extends Experiencia {
	private String prof;
	private String carta;
	private int aval;
	
	public ExperienciaRecomendacao(int valor_base, String prof, String carta, int aval) {
		super(valor_base);
		this.prof = prof;
		this.carta = carta;
		this.aval = aval;
		
		if (!(this.aval >= 1 && this.aval <= 3)) {
			throw new IllegalArgumentException("Valor inválido para o aval!");
		}
	}

	@Override
	public double calculaPontuacao() {
		return this.aval + valor_base;	
		}

	@Override
	public String exibeDetalhamento(int codigo) {
		return "ExperienciaRecomendacao#" + codigo + "[prof=" + prof + ", carta=" + carta + ", aval=" + aval + ", pontuacao=" + calculaPontuacao() + "]";
	}

}
