package unity;

import static org.junit.Assert.*;
import conta.*;
import caixaEletronico.*;
import org.junit.Test;

public class TestesDeUnidade {
	Hardware h;
	Software s;
	Senha p;
	
	@Test
	public void testSenha() {
		Senha p = new Senha();
		assertEquals(p.setSenha("123ab#12"), "Senha aprovada");
		p = new Senha();
		assertEquals(p.setSenha("123ab#"), "A senha deve conter pelo menos 8 digitos");
		p = new Senha();
		assertEquals(p.setSenha("12345678"), "ERRO DE SENHA:\n"
				+ "A senha não atende os requisitos de possuir"
				+ " letras, números e ao menos um caracter especial");
	}
	
	@Test
	public void testOperacoes(){
		h = new Hardware();
		s = h.soft;
		
		s.criarContaCorrente("123ab#12", 10, "Fabio", "123456789");
		
		s.acessoDeUsuario(0, "123ab#12");
		assertEquals(10, s.consultaSaldo());
		
		s.deposito(1000);
		assertEquals(1010, s.consultaSaldo());
		
		s.pagamento(900);
		assertEquals(110, s.consultaSaldo());
	}
	
	@Test
	public void testMultipleInstaces(){
		h = new Hardware();
		s = h.soft;
		
		Software s2 = Software.getInstance();
		assertEquals(s, s2);
		
		//como podemos verificar ao se tentar criar outra
		//instacia do objeto ele retorna a mesma instancia
	}

}
