package testes_recruitMe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recruitMe.Experiencia;
import recruitMe.ExperienciaDesenvolvimento;

public class ExperienciaDesenvolvimentoTest {
	private Experiencia e1;
	private Experiencia e2;
	private Experiencia e3;

	@BeforeEach
	void setUp() {
		this.e1 = new ExperienciaDesenvolvimento(4, "pequena descricao", "www.algumaCoisa", 2);
		this.e2 = new ExperienciaDesenvolvimento(-1, "algo", "www.teste", 3);
		this.e3 = new ExperienciaDesenvolvimento(6, "generico", "www.aaaaa", 9);	
	}
	
	@Test
	void calculaCorretamente() {
		assertEquals(0.8, e1.calculaPontuacao());
	}
	
	
}
