package recruitMe;

public abstract class Experiencia {
	protected int valor_base;
	
	public Experiencia(int valor_base) {
		this.valor_base = valor_base;
	}
	
	public int getValorBase() {
		return this.valor_base;
	}
	
	public abstract double calculaPontuacao();

	public abstract String exibeDetalhamento(int codigo);

}
